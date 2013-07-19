package com.jjw.messagingsystem.controller;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jjw.messagingsystem.domain.User;

@Controller
@RequestMapping("/login")
public class LoginController extends MessagingSystemControllerAbs
{
    private static final Logger myLogger = Logger.getLogger(LoginController.class.getName());

    @RequestMapping(method = RequestMethod.GET)
    public String getLogin(ModelMap model)
    {
        myLogger.info("Handling request for login page");

        // Test
        User user = new User();
        user.setFirstName("Josh");
        user.setLastName("Wyse");
        user.setNickName("J-Dub");
        myUserService.addNewUser(user);

        return VIEW_LOGIN;
    }
}
