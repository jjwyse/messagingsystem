package com.jjw.messagingsystem.controller;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Home controller that gets hit when the user goes to our root URL
 * 
 * @author jjwyse
 * 
 */
@Controller
@RequestMapping("/")
public class HomeController extends MessagingSystemControllerAbs
{
    private static final Logger myLogger = Logger.getLogger(HomeController.class.getName());

    /**
     * Redirects the user to their inbox. If they're not logged in then Spring Security will re-route the URL
     * accordingly
     * 
     * @return The view
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getHome()
    {
        myLogger.info("Handling GET request in home controller");

        return REDIRECT + VIEW_INBOX;
    }
}
