package com.jjw.messagingsystem.dao.impl;

import org.junit.Test;

import com.jjw.messagingsystem.MessagingSystemAbsTest;
import com.jjw.messagingsystem.dto.GroupDTO;

public class GroupDAOImplTest extends MessagingSystemAbsTest
{
    @Test
    public void test()
    {
        GroupDAOImpl dao = new GroupDAOImpl();
        dao.createGroup(new GroupDTO("TestGroup"));

        assert (dao.groupExists("TestGroup"));
    }
}
