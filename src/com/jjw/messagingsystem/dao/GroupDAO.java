package com.jjw.messagingsystem.dao;

/**
 * Group Data Access Object, providing an interface to our group data store
 * 
 * @author jjwyse
 * 
 */
public interface GroupDAO
{
    /**
     * Checks to see if a group by that group name exists in our data store
     * 
     * @param groupName The group name to see if it exists
     * @return true if it exists
     */
    boolean groupExists(String groupName);
}
