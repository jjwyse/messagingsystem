package com.jjw.messagingsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.jjw.messagingsystem.dao.UserDAO;
import com.jjw.messagingsystem.domain.User;
import com.jjw.messagingsystem.service.UserService;

public class UserServiceImpl implements UserService
{
    @Autowired
    private UserDAO myUserDAO;

    @Override
    public void addNewUser(User user)
    {
        myUserDAO.addNewUser(user);
    }
}
