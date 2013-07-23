package com.jjw.messagingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserServiceFactory;
import com.jjw.messagingsystem.MessagingSystemConstantsIF;
import com.jjw.messagingsystem.service.MessageServiceIF;
import com.jjw.messagingsystem.service.UserServiceIF;

public abstract class MessagingSystemControllerAbs implements MessagingSystemConstantsIF
{
    @Autowired
    protected UserServiceIF myUserService;

    @Autowired
    protected MessageServiceIF myMessageService;

    protected String getCurrentUserName()
    {
        User currentUser = UserServiceFactory.getUserService().getCurrentUser();
        return currentUser.getNickname();
    }
}
