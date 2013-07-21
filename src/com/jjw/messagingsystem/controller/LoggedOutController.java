package com.jjw.messagingsystem.controller;

import java.util.logging.Logger;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/loggedout")
public class LoggedOutController extends MessagingSystemControllerAbs
{
    private static final Logger myLogger = Logger.getLogger(LoggedOutController.class.getName());

    @RequestMapping(method = RequestMethod.GET)
    public String getLoggedOut(ModelMap model)
    {
        myLogger.info("Handling GET request in logged out controller");

        return "loggedout";
    }
}
