package com.jjw.messagingsystem.controller;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/inbox")
public class InboxController extends MessagingSystemControllerAbs
{
    private static final Logger myLogger = Logger.getLogger(InboxController.class.getName());

    @RequestMapping(method = RequestMethod.GET)
    public String getInbox(ModelMap model)
    {
        myLogger.info("Handling GET request in inbox controller");

        return VIEW_INBOX;
    }
}
