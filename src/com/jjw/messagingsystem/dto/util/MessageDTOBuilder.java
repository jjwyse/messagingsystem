package com.jjw.messagingsystem.dto.util;

import org.springframework.util.Assert;

import com.google.appengine.api.datastore.Entity;
import com.jjw.messagingsystem.dto.MessageDTO;

public class MessageDTOBuilder extends MessagingSystemDTOBuilder
{
    public static MessageDTO fromEntity(Entity messageEntity)
    {
        Assert.notNull(messageEntity, "Message entity cannot be null");

        MessageDTO messageDTO = new MessageDTO();

        messageDTO.setMessageId((Long) messageEntity.getProperty(MESSAGE_TYPE));
        messageDTO.setFromUserName((String) messageEntity.getProperty(MESSAGE_FROM_USERNAME));
        messageDTO.setToUserName((String) messageEntity.getProperty(MESSAGE_TO_USERNAME));
        messageDTO.setContent((String) messageEntity.getProperty(MESSAGE_CONTENT));
        messageDTO.setDate((String) messageEntity.getProperty(MESSAGE_DATE));

        return messageDTO;
    }

    public static Entity toEntity(MessageDTO message)
    {
        Entity messageEntity = new Entity(MESSAGE_TYPE);
        messageEntity.setProperty(MESSAGE_FROM_USERNAME, message.getFromUserName());
        messageEntity.setProperty(MESSAGE_TO_USERNAME, message.getToUserName());
        messageEntity.setProperty(MESSAGE_CONTENT, message.getContent());
        messageEntity.setProperty(MESSAGE_DATE, message.getDate());

        return messageEntity;
    }
}
