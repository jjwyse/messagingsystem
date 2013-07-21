package com.jjw.messagingsystem.controller;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController extends MessagingSystemControllerAbs
{
    private static final Logger myLogger = Logger.getLogger(LoginController.class.getName());

    @RequestMapping(method = RequestMethod.GET)
    public String getLogin(ModelMap model)
    {
        myLogger.info("Handling get in login controller");

        return VIEW_LOGIN;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String postLogin(@RequestParam("userName") String userName, @RequestParam("password") String password,
            ModelMap model)
    {
        myLogger.info("Handling post in login controller");

        return REDIRECT + VIEW_INBOX;
    }
}
