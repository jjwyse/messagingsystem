package com.jjw.messagingsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.jjw.messagingsystem.dao.UserDAO;
import com.jjw.messagingsystem.dto.UserDTO;
import com.jjw.messagingsystem.service.UserService;

public class UserServiceImpl implements UserService
{
    @Autowired
    private UserDAO myUserDAO;

    @Override
    public void addNewUser(UserDTO user)
    {
        myUserDAO.addNewUser(user);
    }
}
