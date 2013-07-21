package com.jjw.messagingsystem.service;

import com.jjw.messagingsystem.MessagingSystemConstantsIF;
import com.jjw.messagingsystem.dto.UdacityUser;

public interface UserService extends MessagingSystemConstantsIF
{
    UdacityUser findUser(String userId);

    void registerUser(UdacityUser newUser);

    void removeUser(String userId);

}
