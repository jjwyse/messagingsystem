package com.jjw.messagingsystem.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
public class LoginController
{
    private static final Logger myLogger = Logger.getLogger(LoginController.class.getName());

    @Autowired
    String myMessage;

    @RequestMapping(method = RequestMethod.GET)
    public String getLogin(ModelMap model)
    {
        myLogger.info("JJW - message: " + myMessage);

        model.addAttribute("movie", "OfficeSpace");
        model.addAttribute("message", myMessage);

        return "login";
    }
}
