package com.jjw.messagingsystem.service;

import java.util.List;

import com.jjw.messagingsystem.dto.MessageDTO;

/**
 * Service interface to the messages in our system
 * 
 * @author jjwyse
 * 
 */
public interface MessageServiceIF extends MessagingSystemServiceIF
{
    /**
     * Find all messages in the system for this user name
     * 
     * @param userName The user name to retrieve messages for
     * @return The message for this username
     */
    List<MessageDTO> findAllMessages(String userName);

    /**
     * Send a message to a user or group in the system
     * 
     * @param message The message to send
     */
    void sendMessage(MessageDTO message);
}
