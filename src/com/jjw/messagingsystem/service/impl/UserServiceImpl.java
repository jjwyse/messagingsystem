package com.jjw.messagingsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.jjw.messagingsystem.dao.UserDAO;
import com.jjw.messagingsystem.dto.UserDTO;
import com.jjw.messagingsystem.service.UserServiceIF;

public class UserServiceImpl implements UserServiceIF
{
    @Autowired
    private UserDAO myUserDAO;

    public UserDTO findUser(String userName)
    {
        return myUserDAO.findUser(userName);
    }

    public void registerUser(UserDTO newUser)
    {
        myUserDAO.registerUser(newUser);
    }

    public void removeUser(String userId)
    {
        myUserDAO.removeUser(userId);
    }

}
