package com.jjw.messagingsystem.dao;

import com.jjw.messagingsystem.dto.UserDTO;

public interface UserDAO
{
    void addNewUser(UserDTO user);

    UserDTO getUserInfo(String username);
}
