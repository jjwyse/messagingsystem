package com.jjw.messagingsystem.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.datanucleus.util.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.appengine.api.users.UserServiceFactory;
import com.jjw.messagingsystem.dto.UserDTO;
import com.jjw.messagingsystem.form.registration.RegistrationForm;
import com.jjw.messagingsystem.security.googleappengine.GoogleAppEngineUserAuthentication;
import com.jjw.messagingsystem.security.util.MessagingSystemRole;

/**
 * Registration controller that gets hit when a user has authenticated but has never registered for the messaging system
 * 
 * @author jjwyse
 */
@Controller
@RequestMapping(value = "/registration")
public class RegistrationController extends MessagingSystemControllerAbs
{
    private static final Logger myLogger = Logger.getLogger(RegistrationController.class.getName());

    /**
     * Handles GET requests for the registration page. This renders the registration form to the user
     * 
     * @return The registration form for the user to fill out
     */
    @RequestMapping(method = RequestMethod.GET)
    public RegistrationForm registrationForm()
    {
        myLogger.info("Handling GET request in registration controller");

        // Show an example of how to use groups
        RegistrationForm registrationForm = new RegistrationForm();
        registrationForm.setGroups("group1,...");

        return registrationForm;
    }

    /**
     * Handles our POST requests, which means a user is trying to post their registration form they filled out. Make
     * sure everything is legit and then create the user in our datastore and send them to their inbox
     * 
     * @param form The registration form the user filled out
     * @param result The validation results of the form
     * @return Back to register if their form was invalid or onto their inbox if it was good
     */
    @RequestMapping(method = RequestMethod.POST)
    public String register(@Valid RegistrationForm form, BindingResult result)
    {
        myLogger.info("Handling POST request in registration controller");

        if (result.hasErrors())
        {
            return REDIRECT + VIEW_REGISTER;
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDTO currentUser = (UserDTO) authentication.getPrincipal();
        Set<MessagingSystemRole> roles = EnumSet.of(MessagingSystemRole.USER);

        if (UserServiceFactory.getUserService().isUserAdmin())
        {
            roles.add(MessagingSystemRole.ADMIN);
        }

        // Hacky - I hate this
        String groupString = form.getGroups();
        List<String> groups = new ArrayList<String>();
        if (StringUtils.notEmpty(groupString))
        {
            groups = Arrays.asList(groupString.split(","));
        }

        UserDTO user = new UserDTO(currentUser.getUserName(), currentUser.getEmail(), form.getFirstName(),
                form.getLastName(), roles, groups, true);

        myUserService.registerUser(user);

        // Update the context with the full authentication
        SecurityContextHolder.getContext().setAuthentication(
                new GoogleAppEngineUserAuthentication(user, authentication.getDetails()));

        return REDIRECT + VIEW_INBOX;
    }
}
