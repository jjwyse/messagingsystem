package com.jjw.messagingsystem.dao;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.jjw.messagingsystem.MessagingSystemConstantsIF;

/**
 * Abstract Data Access Object base class to provide common functionality between our DAOs
 * 
 * @author jjwyse
 * 
 */
public abstract class MessagingSystemDAOAbs implements MessagingSystemConstantsIF
{
    /**
     * Helper method to retrieve our datastore
     * 
     * @return The GAE DataStoreService
     */
    protected DatastoreService getDatastore()
    {
        return DatastoreServiceFactory.getDatastoreService();
    }
}
