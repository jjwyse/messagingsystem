package com.jjw.messagingsystem.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.CompositeFilterOperator;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.appengine.api.datastore.Query.SortDirection;
import com.jjw.messagingsystem.dao.MessageDAO;
import com.jjw.messagingsystem.dao.MessagingSystemDAOAbs;
import com.jjw.messagingsystem.dto.MessageDTO;
import com.jjw.messagingsystem.dto.UserDTO;
import com.jjw.messagingsystem.dto.util.MessageDTOBuilder;
import com.jjw.messagingsystem.dto.util.UserDTOBuilder;

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
        List<MessageDTO> results = new ArrayList<MessageDTO>();

        myLogger.info("Retrieving messages for user: " + userName);

        // Find user first, can't do joins in GAE datastore - should I do this at the controller level to not add
        // data access logic in the message data access object?
        Key userKey = KeyFactory.createKey(USER_TYPE, userName);
        UserDTO user;
        try
        {
            Entity entityUser = getDatastore().get(userKey);
            user = UserDTOBuilder.fromEntity(entityUser);
        }
        catch (EntityNotFoundException e)
        {
            myLogger.warning("Cannot find user for user name : " + userName);
            return null;
        }

        // Use class Query to assemble a query where we only get messages for this user name
        Filter toGroupNameFilter = new FilterPredicate(MESSAGE_TO_GROUPNAME, FilterOperator.IN, user.getGroups());
        Filter toUserNameFilter = new FilterPredicate(MESSAGE_TO_USERNAME, FilterOperator.EQUAL, userName);
        Filter toAllGroupMembers = new FilterPredicate(MESSAGE_TO_GROUPNAME, FilterOperator.EQUAL, GROUP_ZE_WORLD);

        Filter messageIsForMeFilter = CompositeFilterOperator
                .or(toGroupNameFilter, toUserNameFilter, toAllGroupMembers);
        myLogger.info("Query to retrieve messages: " + messageIsForMeFilter.toString());

        Query q = new Query(MESSAGE_TYPE).setFilter(messageIsForMeFilter).addSort(MESSAGE_DATE,
                SortDirection.DESCENDING);

        // Use PreparedQuery interface to retrieve results
        PreparedQuery pq = getDatastore().prepare(q);

        for (Entity result : pq.asIterable())
        {
            results.add(MessageDTOBuilder.fromEntity(result));
        }

        return results;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sendMessage(MessageDTO message)
    {
        myLogger.info("Sending message to user: " + message.getToUserName());

        Entity messageEntity = MessageDTOBuilder.toEntity(message);

        getDatastore().put(messageEntity);
    }
}
