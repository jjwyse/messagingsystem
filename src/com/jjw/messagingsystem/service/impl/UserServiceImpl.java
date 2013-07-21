package com.jjw.messagingsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.jjw.messagingsystem.dao.UserDAO;
import com.jjw.messagingsystem.dto.GoogleAppEngineUser;
import com.jjw.messagingsystem.service.UserService;

public class UserServiceImpl implements UserService
{
    @Autowired
    private UserDAO myUserDAO;

    public GoogleAppEngineUser findUser(String userId)
    {
        return myUserDAO.findUser(userId);
    }

    public void registerUser(GoogleAppEngineUser newUser)
    {
        myUserDAO.registerUser(newUser);
    }

    public void removeUser(String userId)
    {
        myUserDAO.removeUser(userId);
    }

}
