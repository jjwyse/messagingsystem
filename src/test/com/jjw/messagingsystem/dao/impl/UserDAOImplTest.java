package com.jjw.messagingsystem.dao.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.junit.Test;

import com.jjw.messagingsystem.MessagingSystemAbsTest;
import com.jjw.messagingsystem.dto.UserDTO;
import com.jjw.messagingsystem.security.util.MessagingSystemRole;

public class UserDAOImplTest extends MessagingSystemAbsTest
{
    String me = "joshua.wyse";
    String alphabet = "abcdefghijklmnopqrstuvwxyz";

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
    public void testRegisterLotsOfUsers()
    {
        Set<MessagingSystemRole> roles = new HashSet<MessagingSystemRole>();
        List<String> groups = new ArrayList<String>();
        groups.add("cse174");

        Random random = new Random();

        UserDAOImpl userDaoImpl = new UserDAOImpl();

        String userString = alphabet.charAt(random.nextInt(26)) + me + alphabet.charAt(random.nextInt(26));

        UserDTO user = new UserDTO(userString, "joshua.wyse@gmail.com", "joshua", "wyse", roles, groups, true);
        userDaoImpl.registerUser(user);
        for (int i = 0; i < 10000; i++)
        {
            userDaoImpl.registerUser(user);
            assert (userDaoImpl.findUser(userString) != null);
        }

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
