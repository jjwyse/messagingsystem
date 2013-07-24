package com.jjw.messagingsystem.dao.impl;

import java.util.logging.Logger;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.jjw.messagingsystem.dao.GroupDAO;
import com.jjw.messagingsystem.dao.MessagingSystemDAOAbs;
import com.jjw.messagingsystem.dto.GroupDTO;
import com.jjw.messagingsystem.dto.util.GroupDTOBuilder;

public class GroupDAOImpl extends MessagingSystemDAOAbs implements GroupDAO
{
    private static final Logger myLogger = Logger.getLogger(GroupDAOImpl.class.getName());

    @Override
    public boolean groupExists(String groupName)
    {
        Key key = getGroupKey(groupName);

        try
        {
            Entity groupEntity = getDatastore().get(key);
            myLogger.info("User: " + groupName + " exists in the datastore");
            return true;
        }
        catch (EntityNotFoundException e)
        {
            myLogger.warning(groupName + " not found in datastore");
            return false;
        }
    }

    @Override
    public void createGroup(GroupDTO group)
    {
        Entity groupEntity = GroupDTOBuilder.toEntity(group);

        getDatastore().put(groupEntity);
    }

    /**
     * Helper method to get the key for our groups entity
     * 
     * @param groupName
     * @return The key for our group entity
     */
    private Key getGroupKey(String groupName)
    {
        return KeyFactory.createKey(GROUP_TYPE, groupName);
    }

}
