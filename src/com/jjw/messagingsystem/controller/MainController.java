package com.jjw.messagingsystem.controller;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({ "/", "/home" })
public class MainController extends MessagingSystemControllerAbs
{
    private static final Logger myLogger = Logger.getLogger(MainController.class.getName());

    @RequestMapping(method = RequestMethod.GET)
    public String getMain(ModelMap model)
    {
        myLogger.info("Handling GET in main controller");

        return REDIRECT + VIEW_LOGIN;
    }
}
