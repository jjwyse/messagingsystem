package com.jjw.messagingsystem.dao.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.jjw.messagingsystem.MessagingSystemAbsTest;
import com.jjw.messagingsystem.dto.UserDTO;
import com.jjw.messagingsystem.security.util.MessagingSystemRole;

public class UserDAOImplTest extends MessagingSystemAbsTest
{
    String me = "joshua.wyse";

    @Test
    public void testFindUser()
    {
        UserDAOImpl user = new UserDAOImpl();
        assert (user.findUser(me) == null);
    }

    @Test
    public void testRegisterUser()
    {
        Set<MessagingSystemRole> roles = new HashSet<MessagingSystemRole>();
        List<String> groups = new ArrayList<String>();
        groups.add("cse174");
        UserDTO user = new UserDTO(me, "joshua.wyse@gmail.com", "joshua", "wyse", roles, groups, true);

        UserDAOImpl userDaoImpl = new UserDAOImpl();
        userDaoImpl.registerUser(user);

        assert (userDaoImpl.findUser(me) != null);
    }

    @Test
    public void testRemoveUser()
    {
        Set<MessagingSystemRole> roles = new HashSet<MessagingSystemRole>();
        List<String> groups = new ArrayList<String>();
        groups.add("cse174");
        UserDTO user = new UserDTO(me, "joshua.wyse@gmail.com", "joshua", "wyse", roles, groups, true);

        UserDAOImpl userDaoImpl = new UserDAOImpl();
        userDaoImpl.registerUser(user);

        assert (userDaoImpl.findUser(me) != null);
        userDaoImpl.removeUser(me);

        assert (userDaoImpl.findUser(me) == null);

    }

    @Test
    public void testUserExists()
    {
        Set<MessagingSystemRole> roles = new HashSet<MessagingSystemRole>();
        List<String> groups = new ArrayList<String>();
        groups.add("cse174");
        UserDTO user = new UserDTO(me, "joshua.wyse@gmail.com", "joshua", "wyse", roles, groups, true);

        UserDAOImpl userDaoImpl = new UserDAOImpl();
        userDaoImpl.registerUser(user);

        assert (userDaoImpl.userExists(me));
    }
}
