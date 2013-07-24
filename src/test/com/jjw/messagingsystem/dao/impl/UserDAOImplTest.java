package com.jjw.messagingsystem.dao.impl;

import static org.junit.Assert.fail;

import org.junit.Test;

import com.jjw.messagingsystem.MessagingSystemAbsTest;
import com.jjw.messagingsystem.dto.UserDTO;

public class UserDAOImplTest extends MessagingSystemAbsTest
{

    @Test(expected = Exception.class)
    public void test()
    {
        UserDAOImpl dao = new UserDAOImpl();
        dao.registerUser(new UserDTO("jdub", "jdub@gmail.com", null, null));
        fail("Should have thrown exception from passing in null values above");
    }
}
