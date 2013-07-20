package com.jjw.messagingsystem.controller;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jjw.messagingsystem.dto.UserDTO;

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
    public String postNewUser(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
            @RequestParam("userName") String userName, @RequestParam("password") String password,
            @RequestParam("email") String email, ModelMap model)
    {
        Assert.notNull(firstName, "First name is null, we need one of those");
        Assert.notNull(lastName, "Last name is null, we need one of those");
        Assert.notNull(userName, "User name is null, we need one of those");
        Assert.notNull(password, "Password is null, we need one of those");

        myLogger.info("Handling POST request in new user controller");

        myUserService.addNewUser(new UserDTO(firstName, lastName, userName, password, email));

        return null;
    }
}
