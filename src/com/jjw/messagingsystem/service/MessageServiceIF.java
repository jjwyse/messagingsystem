package com.jjw.messagingsystem.service;

import java.util.List;

import com.jjw.messagingsystem.dto.MessageDTO;

public interface MessageServiceIF extends MessagingSystemServiceIF
{
    List<MessageDTO> findAllMessages(String userName);

    void sendMessageToUser(MessageDTO message);

    void sendMessageToGroup(MessageDTO message);

    void sendMessageToEveryone(MessageDTO message);
}
