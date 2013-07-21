package com.jjw.messagingsystem.controller;

import java.util.logging.Logger;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/disabled")
public class DisabledController extends MessagingSystemControllerAbs
{
    private static final Logger myLogger = Logger.getLogger(DisabledController.class.getName());

    @RequestMapping(method = RequestMethod.GET)
    public String getDisabled(ModelMap model)
    {
        myLogger.info("Handling GET request in disabled controller");

        return "disabled";
    }

}
