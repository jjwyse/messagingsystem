package com.jjw.messagingsystem.controller;

import java.util.EnumSet;
import java.util.Set;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.appengine.api.users.UserServiceFactory;
import com.jjw.messagingsystem.dto.UdacityUser;
import com.jjw.messagingsystem.security.udacity.UdacityUserAuthentication;
import com.jjw.messagingsystem.security.util.AppRole;
import com.jjw.messagingsystem.security.validation.RegistrationForm;
import com.jjw.messagingsystem.service.UserService;

/**
 * 
 * @author Luke Taylor
 */

@Controller
@RequestMapping(value = "/register")
public class RegistrationController extends MessagingSystemControllerAbs
{
    private static final Logger myLogger = Logger.getLogger(RegistrationController.class.getName());

    @Autowired
    private UserService myUserService;

    @RequestMapping(method = RequestMethod.GET)
    public RegistrationForm registrationForm()
    {
        myLogger.info("Handling GET request in registration controller");

        return new RegistrationForm();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String register(@Valid RegistrationForm form, BindingResult result)
    {
        myLogger.info("Handling POST request in registration controller");

        if (result.hasErrors())
        {
            return null;
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UdacityUser currentUser = (UdacityUser) authentication.getPrincipal();
        Set<AppRole> roles = EnumSet.of(AppRole.USER);

        if (UserServiceFactory.getUserService().isUserAdmin())
        {
            roles.add(AppRole.ADMIN);
        }

        UdacityUser user = new UdacityUser(currentUser.getUserId(), currentUser.getNickname(), currentUser.getEmail(),
                form.getForename(), form.getSurname(), roles, true);

        myUserService.registerUser(user);

        // Update the context with the full authentication
        SecurityContextHolder.getContext().setAuthentication(
                new UdacityUserAuthentication(user, authentication.getDetails()));

        return REDIRECT + VIEW_INBOX;
    }
}
