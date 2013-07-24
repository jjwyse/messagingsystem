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
     * Send a message to a specific user in our system
     * 
     * @param message The message to send
     */
    void sendMessageToUser(MessageDTO message);

    /**
     * Send a message to a specific group in our system
     * 
     * @param message The message to send
     */
    void sendMessageToGroup(MessageDTO message);
}
