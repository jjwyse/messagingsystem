package com.jjw.messagingsystem.controller;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller that gets hit when a user is disabled in the datastore
 * 
 * @author jjwyse
 * 
 */
@Controller
@RequestMapping(value = "/disabled")
public class DisabledController extends MessagingSystemControllerAbs
{
    private static final Logger myLogger = Logger.getLogger(DisabledController.class.getName());

    /**
     * Returns the view for the disabled users
     * 
     * @return The disabled view
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getDisabled()
    {
        myLogger.info("Handling GET request in disabled controller");

        return VIEW_DISABLED;
    }

}
