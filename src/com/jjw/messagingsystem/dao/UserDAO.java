package com.jjw.messagingsystem.dao;

import com.jjw.messagingsystem.dto.UdacityUser;

public interface UserDAO
{
    UdacityUser findUser(String userId);

    void registerUser(UdacityUser newUser);

    void removeUser(String userId);
}
