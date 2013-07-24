package com.jjw.messagingsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.jjw.messagingsystem.dao.GroupDAO;
import com.jjw.messagingsystem.service.GroupServiceIF;

public class GroupServiceImpl implements GroupServiceIF
{
    @Autowired
    GroupDAO myGroupDao;

    @Override
    public boolean groupExists(String groupName)
    {
        return myGroupDao.groupExists(groupName);
    }
}
