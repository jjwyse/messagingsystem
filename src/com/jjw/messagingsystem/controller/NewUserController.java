package com.jjw.messagingsystem.controller;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/newUser")
public class NewUserController extends MessagingSystemControllerAbs
{
    private static final Logger myLogger = Logger.getLogger(NewUserController.class.getName());

    @RequestMapping(method = RequestMethod.GET)
    public String getNewUser(ModelMap model)
    {
        myLogger.info("Handling GET request in new user controller");

        return VIEW_NEW_USER;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String postNewUser(ModelMap model)
    {

    }
}
