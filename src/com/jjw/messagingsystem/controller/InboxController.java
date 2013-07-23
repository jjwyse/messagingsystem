package com.jjw.messagingsystem.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jjw.messagingsystem.dto.MessageDTO;
import com.jjw.messagingsystem.util.TimeUtil;

@Controller
@RequestMapping("/inbox")
public class InboxController extends MessagingSystemControllerAbs
{
    private static final Logger myLogger = Logger.getLogger(InboxController.class.getName());

    @RequestMapping(method = RequestMethod.GET)
    public String getInbox(ModelMap model)
    {
        myLogger.info("Handling GET request in inbox controller for user: " + getCurrentUserName());

        // Retrieve all of the messages for this user and put them in our model
        model.put(MODEL_MESSAGES, getMessages());

        return VIEW_INBOX;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String postInbox(ModelMap model)
    {
        myLogger.info("Handling POST request in inbox controller for user: " + getCurrentUserName());

        // Send message to user
        MessageDTO message = new MessageDTO(TimeUtil.getCurrentTime(), "joshua.wyse", "joshua.wyse", "Hello world",
                "04/05/1988");
        myMessageService.sendMessageToUser(message);

        // Retrieve all of the messages for this user and put them in our model
        model.put(MODEL_MESSAGES, getMessages());

        return VIEW_INBOX;
    }

    private List<MessageDTO> getMessages()
    {
        // Retrieve all of the messages for this user and put them in our model
        return myMessageService.findAllMessages(getCurrentUserName());
    }
}
