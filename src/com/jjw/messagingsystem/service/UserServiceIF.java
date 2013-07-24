package com.jjw.messagingsystem.service;

import com.jjw.messagingsystem.dto.UserDTO;

public interface UserServiceIF extends MessagingSystemServiceIF
{
    UserDTO findUser(String userName);

    void registerUser(UserDTO newUser);

    void removeUser(String userId);

    boolean userExists(String userName);

}
