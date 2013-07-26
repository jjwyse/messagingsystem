package com.jjw.messagingsystem.dao.impl;

import java.util.List;

import org.junit.Test;

import com.jjw.messagingsystem.MessagingSystemAbsTest;
import com.jjw.messagingsystem.dto.MessageDTO;

public class MessageDAOImplTest extends MessagingSystemAbsTest
{

    @Test
    public void testFindAllMessages()
    {
        MessageDAOImpl messageDaoImpl = new MessageDAOImpl();

        List<MessageDTO> messages = messageDaoImpl.findAllMessages("joshua.wyse");
        assert (messages == null);

        String to = "joshua.wyse", from = "joshua.wyse", content = "hey josh", group = "cse174";
        MessageDTO message = new MessageDTO(to, group, from, content);
        messageDaoImpl.sendMessage(message);

        messages = messageDaoImpl.findAllMessages("joshua.wyse");
        assert (messages != null);
        assert (messages.size() == 1);
        assert (messages.get(0).getContent().equals(content));
        assert (messages.get(0).getToGroupName().equals(group));
        assert (messages.get(0).getToUserName().equals(to));
        assert (messages.get(0).getFromUserName().equals(from));

    }

    @Test
    public void testSendMessage()
    {
        MessageDAOImpl messageDaoImpl = new MessageDAOImpl();

        List<MessageDTO> messages = messageDaoImpl.findAllMessages("joshua.wyse");

        String to = "joshua.wyse", from = "joshua.wyse", content = "hey josh", group = "cse174";
        MessageDTO message = new MessageDTO(to, group, from, content);
        messageDaoImpl.sendMessage(message);

        messages = messageDaoImpl.findAllMessages("joshua.wyse");
        assert (messages != null);
        assert (messages.size() == 1);
        assert (messages.get(0).getContent().equals(content));
        assert (messages.get(0).getToGroupName().equals(group));
        assert (messages.get(0).getToUserName().equals(to));
        assert (messages.get(0).getFromUserName().equals(from));
    }

}
