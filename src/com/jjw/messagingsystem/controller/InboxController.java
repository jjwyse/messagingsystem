package com.jjw.messagingsystem.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jjw.messagingsystem.dto.MessageDTO;
import com.jjw.messagingsystem.form.compose.ComposeForm;

@Controller
@RequestMapping("/inbox")
public class InboxController extends MessagingSystemControllerAbs
{
    private static final Logger myLogger = Logger.getLogger(InboxController.class.getName());

    @RequestMapping(method = RequestMethod.GET)
    public ComposeForm getInbox(ModelMap model)
    {
        myLogger.info("Handling GET request in inbox controller for user: " + getCurrentUserName());

        // Retrieve all of the messages for this user and put them in our model
        model.put(MODEL_MESSAGES, getMessages());

        return new ComposeForm();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String postInbox(@Valid ComposeForm form, BindingResult result, ModelMap model)
    {
        myLogger.info("Handling POST request in inbox controller for user: " + getCurrentUserName());

        if (result.hasErrors())
        {
            model.addAttribute(MODEL_ERROR, "Invalid data in compose form");
            return REDIRECT + VIEW_INBOX;
        }

        // Send message to user
        MessageDTO message = new MessageDTO(form.getToUserName(), getCurrentUserName(), form.getContent(),
                form.getSubject());
        myMessageService.sendMessageToUser(message);

        // Retrieve all of the messages for this user and put them in our model
        model.put(MODEL_MESSAGES, getMessages());

        return REDIRECT + VIEW_INBOX;
    }

    private List<MessageDTO> getMessages()
    {
        // Retrieve all of the messages for this user and put them in our model
        return myMessageService.findAllMessages(getCurrentUserName());
    }
}
