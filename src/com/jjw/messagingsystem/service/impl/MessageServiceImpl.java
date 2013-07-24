package com.jjw.messagingsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jjw.messagingsystem.dao.MessageDAO;
import com.jjw.messagingsystem.dto.MessageDTO;
import com.jjw.messagingsystem.service.MessageServiceIF;

/**
 * Implementation of message interface to retrieve message information from our data access objects
 * 
 * @author jjwyse
 * 
 */
public class MessageServiceImpl implements MessageServiceIF
{
    /** Message data access object which retrieves our data from the data store */
    @Autowired
    private MessageDAO myMessageDAO;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<MessageDTO> findAllMessages(String userName)
    {
        return myMessageDAO.findAllMessages(userName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sendMessageToUser(MessageDTO message)
    {
        myMessageDAO.sendMessageToUser(message);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void sendMessageToGroup(MessageDTO message)
    {
        myMessageDAO.sendMessageToGroup(message);
    }
}
