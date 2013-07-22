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
import com.jjw.messagingsystem.dto.MessagingSystemUser;
import com.jjw.messagingsystem.security.form.RegistrationForm;
import com.jjw.messagingsystem.security.googleappengine.GoogleAppEngineUserAuthentication;
import com.jjw.messagingsystem.security.util.AppRole;
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
        MessagingSystemUser currentUser = (MessagingSystemUser) authentication.getPrincipal();
        Set<AppRole> roles = EnumSet.of(AppRole.USER);

        if (UserServiceFactory.getUserService().isUserAdmin())
        {
            roles.add(AppRole.ADMIN);
        }

        MessagingSystemUser user = new MessagingSystemUser(currentUser.getUserId(), currentUser.getUserName(),
                currentUser.getEmail(), form.getFirstName(), form.getLastName(), roles, true);

        myUserService.registerUser(user);

        // Update the context with the full authentication
        SecurityContextHolder.getContext().setAuthentication(
                new GoogleAppEngineUserAuthentication(user, authentication.getDetails()));

        return REDIRECT + VIEW_INBOX;
    }
}
