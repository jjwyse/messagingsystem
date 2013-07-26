package com.jjw.messagingsystem.dto.util;

import org.springframework.util.Assert;

import com.google.appengine.api.datastore.Entity;
import com.jjw.messagingsystem.dto.MessageDTO;

/**
 * Helps us transfer our Message Data Transfer Objects to Google App Engine Entities and vice versa. Provide a common
 * place to do this to avoid having the same code everywhere
 * 
 * @author jjwyse
 * 
 */
public class MessageDTOBuilder extends MessagingSystemDTOBuilder
{
    /**
     * Convert an entity into a MessageDTO
     * 
     * @param messageEntity The entity to convert
     * @return The message DTO representation of the entity
     */
    public static MessageDTO fromEntity(Entity messageEntity)
    {
        Assert.notNull(messageEntity, "Message entity cannot be null");

        MessageDTO messageDTO = new MessageDTO();

        messageDTO.setMessageId((Long) messageEntity.getProperty(MESSAGES_TYPE));
        messageDTO.setFromUserName((String) messageEntity.getProperty(MESSAGES_FROM_USERNAME));
        messageDTO.setToUserName((String) messageEntity.getProperty(MESSAGES_TO_USERNAME));
        messageDTO.setToGroupName((String) messageEntity.getProperty(MESSAGES_TO_GROUPNAME));
        messageDTO.setContent((String) messageEntity.getProperty(MESSAGES_CONTENT));
        messageDTO.setDate((String) messageEntity.getProperty(MESSAGES_DATE));

        return messageDTO;
    }

    /**
     * Convert a MessageDTO to a GAE entity
     * 
     * @param message The message DTO to convert to an entity
     * @return The GAE entity for this message DTO
     */
    public static Entity toEntity(MessageDTO message)
    {
        Entity messageEntity = new Entity(MESSAGES_TYPE);
        messageEntity.setProperty(MESSAGES_FROM_USERNAME, message.getFromUserName());
        messageEntity.setProperty(MESSAGES_TO_USERNAME, message.getToUserName());
        messageEntity.setProperty(MESSAGES_TO_GROUPNAME, message.getToGroupName());
        messageEntity.setProperty(MESSAGES_CONTENT, message.getContent());
        messageEntity.setProperty(MESSAGES_DATE, message.getDate());

        return messageEntity;
    }
}
