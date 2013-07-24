package com.jjw.messagingsystem.service;

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
}
