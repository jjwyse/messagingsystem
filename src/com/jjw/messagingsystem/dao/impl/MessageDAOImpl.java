package com.jjw.messagingsystem.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.appengine.api.datastore.Query.SortDirection;
import com.jjw.messagingsystem.dao.MessageDAO;
import com.jjw.messagingsystem.dao.MessagingSystemDAOAbs;
import com.jjw.messagingsystem.dto.MessageDTO;
import com.jjw.messagingsystem.dto.util.MessageDTOBuilder;

public class MessageDAOImpl extends MessagingSystemDAOAbs implements MessageDAO
{
    private static final Logger myLogger = Logger.getLogger(MessageDAOImpl.class.getName());

    @Override
    public List<MessageDTO> findAllMessages(String userName)
    {
        List<MessageDTO> results = new ArrayList<MessageDTO>();

        myLogger.info("Retrieving messages for user: " + userName);

        // Use class Query to assemble a query where we only get messages for this user name
        Filter fromUserNameFilter = new FilterPredicate(MESSAGE_TO_USERNAME, FilterOperator.EQUAL, userName);
        Query q = new Query(MESSAGE_TYPE).setFilter(fromUserNameFilter).addSort(MESSAGE_DATE, SortDirection.DESCENDING);

        // Use PreparedQuery interface to retrieve results
        PreparedQuery pq = getDatastore().prepare(q);

        for (Entity result : pq.asIterable())
        {
            results.add(MessageDTOBuilder.fromEntity(result));
        }

        return results;
    }

    @Override
    public void sendMessageToUser(MessageDTO message)
    {
        myLogger.info("Sending message to user: " + message.getToUserName());

        Entity messageEntity = MessageDTOBuilder.toEntity(message);

        getDatastore().put(messageEntity);
    }

    @Override
    public void sendMessageToGroup(MessageDTO message)
    {
        myLogger.info("Sending message to group: " + message);
    }

    @Override
    public void sendMessageToEveryone(MessageDTO message)
    {
        myLogger.info("Sending message to EVERYONE");
    }
}
