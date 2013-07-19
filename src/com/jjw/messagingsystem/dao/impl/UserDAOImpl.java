package com.jjw.messagingsystem.dao.impl;

import java.util.logging.Logger;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.jjw.messagingsystem.dao.MessagingSystemDAOAbs;
import com.jjw.messagingsystem.dao.UserDAO;
import com.jjw.messagingsystem.dto.UserDTO;
import com.jjw.messagingsystem.dto.builder.UserDTOBuilder;

public class UserDAOImpl extends MessagingSystemDAOAbs implements UserDAO
{
    private static final Logger myLogger = Logger.getLogger(UserDAOImpl.class.getName());

    @Override
    public void addNewUser(UserDTO user)
    {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

        myLogger.info("Putting user: " + user + " into datastore");

        datastore.put(UserDTOBuilder.toEntity(user));
    }
}
