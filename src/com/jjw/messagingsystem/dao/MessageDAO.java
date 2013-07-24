package com.jjw.messagingsystem.dao;

import java.util.List;

import com.jjw.messagingsystem.dto.MessageDTO;

/**
 * Message Data Access Object, providing an interface to our message data store
 * 
 * @author jjwyse
 * 
 */
public interface MessageDAO
{
    /**
     * Finds all messages for the specified user
     * 
     * @param userName The user name to search for messages
     * @return The list of messages for this user
     */
    List<MessageDTO> findAllMessages(String userName);

    /**
     * Sends a message to a specific user
     * 
     * @param message The message to send
     */
    void sendMessageToUser(MessageDTO message);

    /**
     * Sends a message to a specific group
     * 
     * @param message The message to send
     */
    void sendMessageToGroup(MessageDTO message);
}
