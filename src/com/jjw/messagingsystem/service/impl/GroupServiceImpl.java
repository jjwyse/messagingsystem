package com.jjw.messagingsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.jjw.messagingsystem.dao.GroupDAO;
import com.jjw.messagingsystem.service.GroupServiceIF;

/**
 * Implementation which users our data access object to retrieve group data
 * 
 * @author jjwyse
 * 
 */
public class GroupServiceImpl implements GroupServiceIF
{
    /** Group data access object to retrieve data from our data store */
    @Autowired
    GroupDAO myGroupDao;

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean groupExists(String groupName)
    {
        return myGroupDao.groupExists(groupName);
    }
}
