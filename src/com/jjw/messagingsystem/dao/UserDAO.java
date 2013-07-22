package com.jjw.messagingsystem.dao;

import com.jjw.messagingsystem.dto.MessagingSystemUser;

public interface UserDAO
{
    MessagingSystemUser findUser(String userId);

    void registerUser(MessagingSystemUser newUser);

    void removeUser(String userId);
}
