package com.jjw.messagingsystem.service;

import com.jjw.messagingsystem.dto.UserDTO;

public interface UserService
{
    void addNewUser(UserDTO user);

    UserDTO getUserInfo(String username);

    UserDTO getUserInfo(String username, String password);
}
