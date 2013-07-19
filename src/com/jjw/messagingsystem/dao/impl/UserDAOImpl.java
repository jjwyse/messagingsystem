package com.jjw.messagingsystem.dao.impl;

import java.util.logging.Logger;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.jjw.messagingsystem.dao.MessagingSystemDAOAbs;
import com.jjw.messagingsystem.dao.UserDAO;
import com.jjw.messagingsystem.domain.User;

public class UserDAOImpl extends MessagingSystemDAOAbs implements UserDAO
{
    private static final Logger myLogger = Logger.getLogger(UserDAOImpl.class.getName());

    @Override
    public void addNewUser(User user)
    {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

        Entity entity = new Entity(ENTITY_USER);
        entity.setProperty(ENTITY_PROP_FIRST_NAME, user.getFirstName());
        entity.setProperty(ENTITY_PROP_LAST_NAME, user.getLastName());
        entity.setProperty(ENTITY_PROP_NICK_NAME, user.getNickName());

        myLogger.info("Putting user: " + user + " into datastore");

        datastore.put(entity);
    }
}
