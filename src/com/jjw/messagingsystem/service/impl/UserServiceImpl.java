package com.jjw.messagingsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.jjw.messagingsystem.dao.UserDAO;
import com.jjw.messagingsystem.dto.UserDTO;
import com.jjw.messagingsystem.service.UserServiceIF;

public class UserServiceImpl implements UserServiceIF
{
    @Autowired
    private UserDAO myUserDAO;

    @Override
    public UserDTO findUser(String userName)
    {
        return myUserDAO.findUser(userName);
    }

    @Override
    public void registerUser(UserDTO newUser)
    {
        myUserDAO.registerUser(newUser);
    }

    @Override
    public void removeUser(String userId)
    {
        myUserDAO.removeUser(userId);
    }

    @Override
    public boolean userExists(String userName)
    {
        return myUserDAO.userExists(userName);
    }

}
