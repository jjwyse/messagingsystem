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

/**
 * Inbox controller that gets hit when a user has both authenticated and registered for our messaging system.
 * 
 * @author jjwyse
 */
@Controller
@RequestMapping("/inbox")
public class InboxController extends MessagingSystemControllerAbs
{
    private static final Logger myLogger = Logger.getLogger(InboxController.class.getName());

    /**
     * GET requests come here. We update our model with all of our current users' messages and then return a compose
     * form to the browser so the user can POST messages using the form
     * 
     * @param model Model that gets updated with the users' messages
     * @return The compose form to allow the user to compose messages
     */
    @RequestMapping(method = RequestMethod.GET)
    public ComposeForm getInbox(ModelMap model)
    {
        myLogger.info("Handling GET request in inbox controller for user: " + getCurrentUserName());

        // Retrieve all of the messages for this user and put them in our model
        model.put(MODEL_MESSAGES, getMessages());

        return new ComposeForm();
    }

    /**
     * POST requests come here. This POST comes from the compose form, so the user is trying to send a message. First we
     * make sure the form is valid, and then we create a Message from the form and use the message service to send it.
     * 
     * @param form Compose form with the sent message information
     * @param result The validation results for our form
     * @param model Model that gets updated with users' current messages or an error
     * @return Redirect to the GET inbox view
     */
    @RequestMapping(method = RequestMethod.POST)
    public String postInbox(@Valid ComposeForm form, BindingResult result, ModelMap model)
    {
        myLogger.info("Handling POST request in inbox controller for user: " + getCurrentUserName());

        if (result.hasErrors())
        {
            model.put(MODEL_ERROR, "Invalid data in compose form");
            return REDIRECT + VIEW_INBOX;
        }

        // Send message to user
        MessageDTO message = new MessageDTO(form.getToUserName(), form.getToGroupName(), getCurrentUserName(),
                form.getContent());
        myMessageService.sendMessage(message);

        // Retrieve all of the messages for this user and put them in our model
        model.put(MODEL_MESSAGES, getMessages());

        return REDIRECT + VIEW_INBOX;
    }

    /**
     * Helper method to get all the current users' messages
     * 
     * @return The list of messages
     */
    private List<MessageDTO> getMessages()
    {
        // Retrieve all of the messages for this user and put them in our model
        return myMessageService.findAllMessages(getCurrentUserName());
    }
}
