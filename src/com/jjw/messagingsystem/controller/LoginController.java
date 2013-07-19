package com.jjw.messagingsystem.controller;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController extends MessagingSystemControllerAbs
{
    private static final Logger myLogger = Logger.getLogger(LoginController.class.getName());

    @RequestMapping(method = RequestMethod.GET)
    public String getLogin(ModelMap model)
    {
        myLogger.info("Handling request for login page");

        return VIEW_LOGIN;
    }
}
