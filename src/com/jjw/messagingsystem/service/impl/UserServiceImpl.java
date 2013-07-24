package com.jjw.messagingsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.jjw.messagingsystem.dao.UserDAO;
import com.jjw.messagingsystem.dto.UserDTO;
import com.jjw.messagingsystem.service.UserServiceIF;

/**
 * Implementation of our user service interface, used to retrieve user information from our data source
 * 
 * @author jjwyse
 * 
 */
public class UserServiceImpl implements UserServiceIF
{
    /** User data access object, used to retrieve user information from its data source. */
    @Autowired
    private UserDAO myUserDAO;

    /**
     * {@inheritDoc}
     */
    @Override
    public UserDTO findUser(String userName)
    {
        return myUserDAO.findUser(userName);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void registerUser(UserDTO newUser)
    {
        myUserDAO.registerUser(newUser);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeUser(String userId)
    {
        myUserDAO.removeUser(userId);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean userExists(String userName)
    {
        return myUserDAO.userExists(userName);
    }

}
