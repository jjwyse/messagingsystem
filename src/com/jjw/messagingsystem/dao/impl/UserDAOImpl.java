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

/**
 * Implementation of the User Data Access Object interface which handles retrieving and telling us about the users in
 * our system.
 * 
 * @author jjwyse
 * 
 */
public class UserDAOImpl extends MessagingSystemDAOAbs implements UserDAO
{
    private static final Logger myLogger = Logger.getLogger(UserDAOImpl.class.getName());

    @Override
    public UserDTO findUser(String userName)
    {
        Key key = getUserKey(userName);

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

    /**
     * {@inheritDoc}
     */
    @Override
    public void registerUser(UserDTO newUser)
    {
        myLogger.info("Attempting to create new user " + newUser);

        Entity user = UserDTOBuilder.toEntity(newUser);

        getDatastore().put(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeUser(String userId)
    {
        Key key = KeyFactory.createKey(USERS_TYPE, userId);

        getDatastore().delete(key);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean userExists(String userName)
    {
        Key key = getUserKey(userName);

        try
        {
            Entity userEntity = getDatastore().get(key);
            myLogger.info("User: " + userName + " exists in the datastore");
            return true;

        }
        catch (EntityNotFoundException e)
        {
            myLogger.warning(userName + " not found in datastore");
            return false;
        }
    }

    /**
     * Helper method to get the key for our users entity
     * 
     * @param userName
     * @return
     */
    private Key getUserKey(String userName)
    {
        return KeyFactory.createKey(USERS_TYPE, userName);
    }
}
