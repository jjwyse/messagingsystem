package com.jjw.messagingsystem.controller;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController extends MessagingSystemControllerAbs
{
    private static final Logger myLogger = Logger.getLogger(HomeController.class.getName());

    @RequestMapping(method = RequestMethod.GET)
    public String getHome(ModelMap model)
    {
        myLogger.info("Handling GET request in home controller");

        return REDIRECT + VIEW_INBOX;
    }
}
