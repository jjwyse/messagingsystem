package com.jjw.messagingsystem.dto;

/**
 * Group Data Transfer Object that represents a Group in our system
 * 
 * @author jjwyse
 * 
 */
public class GroupDTO
{
    /** The name of our group */
    private String myGroupName;

    public GroupDTO()
    {

    }

    public GroupDTO(String groupName)
    {
        myGroupName = groupName;
    }

    /**
     * @return the groupName
     */
    public String getGroupName()
    {
        return myGroupName;
    }

    /**
     * @param groupName the groupName to set
     */
    public void setGroupName(String groupName)
    {
        myGroupName = groupName;
    }
}
