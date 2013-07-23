package com.jjw.messagingsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.jjw.messagingsystem.dao.MessageDAO;
import com.jjw.messagingsystem.dto.MessageDTO;
import com.jjw.messagingsystem.service.MessageServiceIF;

public class MessageServiceImpl implements MessageServiceIF
{
    @Autowired
    private MessageDAO myMessageDAO;

    @Override
    public List<MessageDTO> findAllMessages(String userName)
    {
        return myMessageDAO.findAllMessages(userName);
    }

    @Override
    public void sendMessageToUser(MessageDTO message)
    {
        myMessageDAO.sendMessageToUser(message);
    }

    @Override
    public void sendMessageToGroup(MessageDTO message)
    {
        myMessageDAO.sendMessageToGroup(message);
    }

    @Override
    public void sendMessageToEveryone(MessageDTO message)
    {
        myMessageDAO.sendMessageToEveryone(message);
    }
}
