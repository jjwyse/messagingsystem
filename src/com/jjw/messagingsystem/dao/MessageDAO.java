package com.jjw.messagingsystem.dao;

import java.util.List;

import com.jjw.messagingsystem.dto.MessageDTO;

public interface MessageDAO
{
    List<MessageDTO> findAllMessages(String userName);

    void sendMessageToUser(MessageDTO message);

    void sendMessageToGroup(MessageDTO message);

    void sendMessageToEveryone(MessageDTO message);
}
