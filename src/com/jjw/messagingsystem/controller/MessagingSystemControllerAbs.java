package com.jjw.messagingsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.jjw.messagingsystem.MessagingSystemConstantsIF;
import com.jjw.messagingsystem.service.UserService;

public abstract class MessagingSystemControllerAbs implements MessagingSystemConstantsIF
{
    @Autowired
    protected UserService myUserService;

}
