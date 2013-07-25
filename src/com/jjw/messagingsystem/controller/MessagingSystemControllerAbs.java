package com.jjw.messagingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserServiceFactory;
import com.jjw.messagingsystem.MessagingSystemConstantsIF;
import com.jjw.messagingsystem.service.GroupServiceIF;
import com.jjw.messagingsystem.service.MessageServiceIF;
import com.jjw.messagingsystem.service.UserServiceIF;

/**
 * Abstract controller that allows common functionality to be created that is used amongst all of our messaging system
 * controllers
 * 
 * @author jjwyse
 * 
 */
public abstract class MessagingSystemControllerAbs implements MessagingSystemConstantsIF
{
    @Autowired
    protected UserServiceIF myUserService;

    @Autowired
    protected MessageServiceIF myMessageService;

    @Autowired
    protected GroupServiceIF myGroupService;

    /**
     * Helper method to get the current user that is logged in for this session
     * 
     * @return The user name
     */
    protected String getCurrentUserName()
    {
        User currentUser = UserServiceFactory.getUserService().getCurrentUser();
        return currentUser.getNickname();
    }
}
