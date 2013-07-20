package com.jjw.messagingsystem.dao.impl;

import java.util.logging.Logger;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.CompositeFilterOperator;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.jjw.messagingsystem.dao.MessagingSystemDAOAbs;
import com.jjw.messagingsystem.dao.UserDAO;
import com.jjw.messagingsystem.dto.UserDTO;
import com.jjw.messagingsystem.dto.util.UserDTOUtil;

public class UserDAOImpl extends MessagingSystemDAOAbs implements UserDAO
{
    private static final Logger myLogger = Logger.getLogger(UserDAOImpl.class.getName());

    @Override
    public void addNewUser(UserDTO user)
    {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

        myLogger.info("Putting user: " + user + " into datastore");

        datastore.put(UserDTOUtil.toEntity(user));
    }

    @Override
    public UserDTO getUserInfo(String userName)
    {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

        myLogger.info("Retrieving user information for user with username: " + userName);

        Filter userNameFilter = new FilterPredicate(ENTITY_PROP_USERNAME, FilterOperator.EQUAL, userName);

        Query query = new Query(ENTITY_USER).setFilter(userNameFilter);

        PreparedQuery preparedQuery = datastore.prepare(query);
        return UserDTOUtil.fromEntity(preparedQuery.asSingleEntity());
    }

    @Override
    public UserDTO getUserInfo(String userName, String password)
    {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

        myLogger.info("Retrieving user information for user with username: " + userName);

        Filter userNameFilter = new FilterPredicate(ENTITY_PROP_USERNAME, FilterOperator.EQUAL, userName);
        Filter passwordFilter = new FilterPredicate(ENTITY_PROP_PASSWORD, FilterOperator.EQUAL, password);

        // Use CompositeFilter to combine multiple filters
        Filter userNameAndPasswordFilter = CompositeFilterOperator.and(userNameFilter, passwordFilter);

        Query query = new Query(ENTITY_USER).setFilter(userNameAndPasswordFilter);

        PreparedQuery preparedQuery = datastore.prepare(query);
        for (Entity entity : preparedQuery.asIterable())
        {
            return UserDTOUtil.fromEntity(entity);
        }
        return null;
    }
}
