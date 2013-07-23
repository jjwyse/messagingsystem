package com.jjw.messagingsystem.dao;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.jjw.messagingsystem.MessagingSystemConstantsIF;

public abstract class MessagingSystemDAOAbs implements MessagingSystemConstantsIF
{
    protected DatastoreService getDatastore()
    {
        return DatastoreServiceFactory.getDatastoreService();
    }
}
