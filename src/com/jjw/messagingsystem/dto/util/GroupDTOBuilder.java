package com.jjw.messagingsystem.dto.util;

import org.springframework.util.Assert;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.jjw.messagingsystem.dto.GroupDTO;

/**
 * Helper class that provides static methods to go from our messaging system domain object to the entity objects that
 * the GAE datastore needs to persist
 * 
 * @author jjwyse
 * 
 */
public class GroupDTOBuilder extends MessagingSystemDTOBuilder
{
    /**
     * Takes a group data transfer object and converts it to a GAE entity object to persist
     * 
     * @param groupDTO The group data transfer object to conver
     * @return The entity object for the data store
     */
    public static Entity toEntity(GroupDTO groupDTO)
    {
        Assert.notNull(groupDTO, "Group DTO cannot be null");

        Key groupKey = KeyFactory.createKey(GROUPS_TYPE, groupDTO.getGroupName());

        Entity groupEntity = new Entity(groupKey);
        groupEntity.setProperty(GROUPS_NAME, groupDTO.getGroupName());

        return groupEntity;
    }
}
