package com.jjw.messagingsystem.dao.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.util.StringUtils;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.jjw.messagingsystem.dao.MessageDAO;
import com.jjw.messagingsystem.dao.MessagingSystemDAOAbs;
import com.jjw.messagingsystem.dto.MessageDTO;
import com.jjw.messagingsystem.dto.util.MessageDTOBuilder;

/**
 * Implementation of the Message Data Access Object interface which handles retrieving and telling us about messages in
 * our system.
 * 
 * @author jjwyse
 * 
 */
public class MessageDAOImpl extends MessagingSystemDAOAbs implements MessageDAO
{
    private static final Logger myLogger = Logger.getLogger(MessageDAOImpl.class.getName());

    /**
     * {@inheritDoc}
     */
    @Override
    public List<MessageDTO> findAllMessages(String userName)
    {
        List<Long> messageIdsForUser = new ArrayList<Long>();

        // Use class Query to assemble a query where we only get messages for this user name
        Filter toUserNameFilter = new FilterPredicate(MESSAGES_TO_USERNAME, FilterOperator.EQUAL, userName);

        Query query = new Query(USERSMESSAGESXREF_TYPE).setFilter(toUserNameFilter);
        myLogger.info("Query to retrieve message IDs for user: " + userName + " is: " + query.toString());

        // Use PreparedQuery interface to retrieve all of the message IDs that belong to this user
        PreparedQuery preparedQuery = getDatastore().prepare(query);
        for (Entity result : preparedQuery.asIterable())
        {
            messageIdsForUser.add((Long) result.getProperty(MESSAGES_ID));
        }

        if (messageIdsForUser.isEmpty())
        {
            myLogger.info("No messages for user: " + userName);
            return null;
        }

        // Now, retrieve all of the message objects
        // Add all keys to a collection so we can batch retrieve our messages
        List<Key> keys = new ArrayList<Key>();
        for (Long messageId : messageIdsForUser)
        {
            keys.add(KeyFactory.createKey(MESSAGES_TYPE, messageId));
        }

        // Add all of our results from our query into the return set
        Map<Key, Entity> messageEntities = getDatastore().get(keys);
        List<MessageDTO> messages = new ArrayList<MessageDTO>();
        for (Entity messagEntity : messageEntities.values())
        {
            messages.add(MessageDTOBuilder.fromEntity(messagEntity));
        }

        // Sort the messages by date and the reverse the order so the newest is first
        Collections.sort(messages);
        Collections.reverse(messages);

        return messages;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sendMessage(MessageDTO message)
    {
        // First insert it into our messages entity
        Entity messageEntity = MessageDTOBuilder.toEntity(message);
        Key messageKey = getDatastore().put(messageEntity);

        myLogger.info("Inserted message with key ID: " + messageKey.getId());

        // Lets just say we'll let users send a message to a user name and a group at the same time.
        // Now, we need to update our Xref that maps userName->messageId
        if (StringUtils.hasText(message.getToGroupName()))
        {
            if (message.getToGroupName().equalsIgnoreCase(GROUP_ZE_WORLD))
            {
                sendMessageToZeWorld(messageKey);
            }
            else
            {
                sendMessageToGroup(message, messageKey);
            }
        }

        if (StringUtils.hasText(message.getToUserName()))
        {
            sendMessageToUser(message, messageKey);
        }

    }

    /**
     * Sends a message to a specific user
     * 
     * @param message The message to insert into our Xref
     * @param messageKey The key of the message we just insert into our message datastore
     */
    private void sendMessageToUser(MessageDTO message, Key messageKey)
    {
        Entity usersMessagesXrefEntity = createXrefEntity(message.getToUserName(), messageKey.getId());
        getDatastore().put(usersMessagesXrefEntity);

        myLogger.info("Updated " + USERSMESSAGESXREF_TYPE + " table: " + message.getToUserName() + "-->"
                + messageKey.getId());
    }

    /**
     * Sends a message to a specific group
     * 
     * @param message The message to insert into our Xref
     * @param messageKey The key of the message we just insert into our message datastore
     */
    private void sendMessageToGroup(MessageDTO message, Key messageKey)
    {
        // Get all the users who are in this group. I have to make a list to pass in to the GAE filter
        // because it's silly like that
        List<String> groupNameList = new ArrayList<String>();
        groupNameList.add(message.getToGroupName());
        Filter inThatGroupNameFilter = new FilterPredicate(USERS_GROUPS, FilterOperator.IN, groupNameList);
        Query query = new Query(USERS_TYPE).setFilter(inThatGroupNameFilter);

        myLogger.info("Executing query to find users who are in the group: " + message.getToGroupName() + ", query: "
                + query.toString());

        // Update our xref entity which represents each users' inbox
        updateXrefEntity(query, messageKey);

        myLogger.info("Updated xref table with all members of the group");
    }

    /**
     * Sends a message to every user in the entire system
     * 
     * @param message The message to send
     * @param messageKey The key of the message
     */
    private void sendMessageToZeWorld(Key messageKey)
    {
        Query query = new Query(USERS_TYPE);

        // Update our xref entity which represents each users' inbox
        updateXrefEntity(query, messageKey);
    }

    /**
     * Executes the query and updates our xref table with all of the users who are in the group filter in our query
     * 
     * @param query The query to be executed
     * @param messageKey The key of the message we want to put in the xref table
     */
    private void updateXrefEntity(Query query, Key messageKey)
    {
        PreparedQuery pq = getDatastore().prepare(query);
        List<String> groupMembers = new ArrayList<String>();
        for (Entity result : pq.asIterable())
        {
            groupMembers.add((String) result.getProperty(USERS_USERNAME));
        }

        // Now, we want to update the xref table with username to messageid
        List<Entity> entities = new ArrayList<Entity>();
        for (String userName : groupMembers)
        {
            entities.add(createXrefEntity(userName, messageKey.getId()));
        }

        getDatastore().put(entities);
    }

    /**
     * Helper method, which creates our xref entity object to insert into our xref table. This xref table maps user
     * names to message IDs and is the way that we retrieve messages for that specific user
     * 
     * @param userName String the user name
     * @param messageId Long the id of the message that belongs to that user
     * @return Entity object to put into our data store
     */
    private Entity createXrefEntity(String userName, Long messageId)
    {
        Entity usersMessagesXrefEntity = new Entity(USERSMESSAGESXREF_TYPE);
        usersMessagesXrefEntity.setProperty(MESSAGES_TO_USERNAME, userName);
        usersMessagesXrefEntity.setProperty(MESSAGES_ID, messageId);
        return usersMessagesXrefEntity;
    }
}
