package com.jjw.messagingsystem.controller;

import java.util.logging.Logger;

import org.datanucleus.util.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jjw.messagingsystem.dto.UserDTO;

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
    public String postLogin(@RequestParam("username") String username, ModelMap model)
    {
        myLogger.info("Handling post in login controller");
        if (StringUtils.isEmpty(username))
        {
            model.addAttribute(MODEL_ERROR, "Please enter a username");
            return VIEW_LOGIN;
        }

        // Check to see if user exists, and if they do, lets bring up their inbox
        UserDTO user = myUserService.getUserInfo(username);
        if (user == null)
        {
            model.addAttribute(MODEL_ERROR, "No user with username: " + username + " in the system");
            return VIEW_LOGIN;
        }

        myLogger.info("Successfully logged in as user: " + user);

        return REDIRECT + VIEW_INBOX;
    }
}
