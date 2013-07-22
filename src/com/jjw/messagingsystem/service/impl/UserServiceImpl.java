package com.jjw.messagingsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.jjw.messagingsystem.dao.UserDAO;
import com.jjw.messagingsystem.dto.MessagingSystemUser;
import com.jjw.messagingsystem.service.UserService;

public class UserServiceImpl implements UserService
{
    @Autowired
    private UserDAO myUserDAO;

    public MessagingSystemUser findUser(String userId)
    {
        return myUserDAO.findUser(userId);
    }

    public void registerUser(MessagingSystemUser newUser)
    {
        myUserDAO.registerUser(newUser);
    }

    public void removeUser(String userId)
    {
        myUserDAO.removeUser(userId);
    }

}
