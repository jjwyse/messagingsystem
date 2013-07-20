package com.jjw.messagingsystem.controller;

import java.util.EnumSet;
import java.util.Set;

import javax.validation.Valid;
import com.google.appengine.api.users.UserServiceFactory;
import com.jjw.messagingsystem.security.AppRole;
import com.jjw.messagingsystem.security.GaeUser;
import com.jjw.messagingsystem.security.GaeUserAuthentication;
import com.jjw.messagingsystem.security.RegistrationForm;
import com.jjw.messagingsystem.security.UserRegistry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author Luke Taylor
 */

@Controller
@RequestMapping(value = "/register.htm")
public class RegistrationController
{
    @Autowired
    private UserRegistry registry;

    @RequestMapping(method = RequestMethod.GET)
    public RegistrationForm registrationForm()
    {
        return new RegistrationForm();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String register(@Valid RegistrationForm form, BindingResult result)
    {
        if (result.hasErrors())
        {
            return null;
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        GaeUser currentUser = (GaeUser) authentication.getPrincipal();
        Set<AppRole> roles = EnumSet.of(AppRole.USER);

        if (UserServiceFactory.getUserService().isUserAdmin())
        {
            roles.add(AppRole.ADMIN);
        }

        GaeUser user = new GaeUser(currentUser.getUserId(), currentUser.getNickname(), currentUser.getEmail(),

        form.getForename(), form.getSurname(), roles, true);

        registry.registerUser(user);

        // Update the context with the full authentication

        SecurityContextHolder.getContext().setAuthentication(
                        new GaeUserAuthentication(user, authentication.getDetails()));

        return "redirect:/home.htm";
    }
}