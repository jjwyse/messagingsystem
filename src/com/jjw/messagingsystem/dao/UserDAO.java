package com.jjw.messagingsystem.dao;

import com.jjw.messagingsystem.dto.UserDTO;

public interface UserDAO
{
    UserDTO findUser(String userName);

    void registerUser(UserDTO newUser);

    void removeUser(String userId);

    boolean userExists(String userName);
}
