package com.jjw.messagingsystem.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.appengine.api.users.UserServiceFactory;

/**
 * Logout controller for when a user wants to log out from their current session
 * 
 * @author jjwyse
 * 
 */
@Controller
@RequestMapping(value = "/logout")
public class LogoutController extends MessagingSystemControllerAbs
{
    private static final Logger myLogger = Logger.getLogger(LogoutController.class.getName());

    @RequestMapping(method = RequestMethod.GET)
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
        myLogger.info("Handling GET request in logout controller");

        request.getSession().invalidate();

        String logoutUrl = UserServiceFactory.getUserService().createLogoutURL("/");

        response.sendRedirect(logoutUrl);
    }
}
