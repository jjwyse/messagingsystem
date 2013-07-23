package com.jjw.messagingsystem.dao.impl;

import java.util.logging.Logger;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.jjw.messagingsystem.dao.MessagingSystemDAOAbs;
import com.jjw.messagingsystem.dao.UserDAO;
import com.jjw.messagingsystem.dto.UserDTO;
import com.jjw.messagingsystem.dto.util.UserDTOBuilder;

public class UserDAOImpl extends MessagingSystemDAOAbs implements UserDAO
{
    private static final Logger myLogger = Logger.getLogger(UserDAOImpl.class.getName());

    @Override
    public UserDTO findUser(String userName)
    {
        Key key = KeyFactory.createKey(USER_TYPE, userName);

        try
        {
            Entity userEntity = getDatastore().get(key);
            UserDTO user = UserDTOBuilder.fromEntity(userEntity);
            return user;

        }
        catch (EntityNotFoundException e)
        {
            myLogger.warning(userName + " not found in datastore");
            return null;
        }
    }

    @Override
    public void registerUser(UserDTO newUser)
    {
        myLogger.info("Attempting to create new user " + newUser);

        Entity user = UserDTOBuilder.toEntity(newUser);

        getDatastore().put(user);
    }

    @Override
    public void removeUser(String userId)
    {
        Key key = KeyFactory.createKey(USER_TYPE, userId);

        getDatastore().delete(key);
    }
}
