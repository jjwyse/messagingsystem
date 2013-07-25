package com.jjw.messagingsystem.service;

import com.jjw.messagingsystem.dto.GroupDTO;

/**
 * Service interface to the groups in our system
 * 
 * @author jjwyse
 * 
 */
public interface GroupServiceIF
{
    /**
     * Check to see if a group exists for this specific group name
     * 
     * @param groupName The group name to check and see if it exists
     * @return true if the group exists, false otherwise
     */
    boolean groupExists(String groupName);

    /**
     * Adds a new group to our group data store
     * 
     * @param newGroup The new group to add to our system
     */
    void addGroup(GroupDTO newGroup);
}
