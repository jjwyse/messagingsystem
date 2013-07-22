package com.jjw.messagingsystem.dao.impl;

import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;
import java.util.logging.Logger;

import org.springframework.security.core.GrantedAuthority;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.jjw.messagingsystem.dao.MessagingSystemDAOAbs;
import com.jjw.messagingsystem.dao.UserDAO;
import com.jjw.messagingsystem.dto.MessagingSystemUser;
import com.jjw.messagingsystem.security.util.AppRole;

public class UserDAOImpl extends MessagingSystemDAOAbs implements UserDAO
{
    private static final Logger myLogger = Logger.getLogger(UserDAOImpl.class.getName());

    @Override
    public MessagingSystemUser findUser(String userId)
    {
        Key key = KeyFactory.createKey(USER_TYPE, userId);
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

        try
        {
            Entity user = datastore.get(key);

            long binaryAuthorities = (Long) user.getProperty(USER_AUTHORITIES);
            Set<AppRole> roles = EnumSet.noneOf(AppRole.class);

            for (AppRole r : AppRole.values())
            {
                if ((binaryAuthorities & (1 << r.getBit())) != 0)
                {
                    roles.add(r);
                }
            }

            MessagingSystemUser googleAppEngineUser = new MessagingSystemUser(user.getKey().getName(),
                    (String) user.getProperty(USER_USERNAME), (String) user.getProperty(USER_EMAIL),
                    (String) user.getProperty(USER_FIRSTNAME), (String) user.getProperty(USER_LASTNAME), roles,
                    (Boolean) user.getProperty(USER_ENABLED));

            return googleAppEngineUser;

        }
        catch (EntityNotFoundException e)
        {
            myLogger.warning(userId + " not found in datastore");
            return null;
        }
    }

    @Override
    public void registerUser(MessagingSystemUser newUser)
    {
        myLogger.info("Attempting to create new user " + newUser);

        Key key = KeyFactory.createKey(USER_TYPE, newUser.getUserId());
        Entity user = new Entity(key);
        user.setProperty(USER_EMAIL, newUser.getEmail());
        user.setProperty(USER_USERNAME, newUser.getUserName());
        user.setProperty(USER_FIRSTNAME, newUser.getFirstName());
        user.setProperty(USER_LASTNAME, newUser.getLastName());
        user.setUnindexedProperty(USER_ENABLED, newUser.isEnabled());

        Collection<? extends GrantedAuthority> roles = newUser.getAuthorities();

        long binaryAuthorities = 0;

        for (GrantedAuthority r : roles)
        {
            binaryAuthorities |= 1 << ((AppRole) r).getBit();
        }

        user.setUnindexedProperty(USER_AUTHORITIES, binaryAuthorities);

        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        datastore.put(user);
    }

    @Override
    public void removeUser(String userId)
    {
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();
        Key key = KeyFactory.createKey(USER_TYPE, userId);

        datastore.delete(key);
    }
}
