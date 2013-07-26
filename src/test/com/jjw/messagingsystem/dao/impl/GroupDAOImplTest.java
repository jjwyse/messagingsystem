package com.jjw.messagingsystem.dao.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.jjw.messagingsystem.MessagingSystemAbsTest;
import com.jjw.messagingsystem.dto.GroupDTO;

public class GroupDAOImplTest extends MessagingSystemAbsTest
{

    @Test
    public void testGroupExists()
    {
        GroupDAOImpl groupDAOImpl = new GroupDAOImpl();
        assertFalse(groupDAOImpl.groupExists("doesNotExist"));

    }

    @Test
    public void testAddGroup()
    {
        GroupDAOImpl groupDAOImpl = new GroupDAOImpl();

        String groupName = "JoshGroup";
        groupDAOImpl.addGroup(new GroupDTO(groupName));

        assertTrue(groupDAOImpl.groupExists(groupName));
    }

}
