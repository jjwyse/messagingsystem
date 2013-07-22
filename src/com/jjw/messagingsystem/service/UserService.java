package com.jjw.messagingsystem.service;

import com.jjw.messagingsystem.MessagingSystemConstantsIF;
import com.jjw.messagingsystem.dto.MessagingSystemUser;

public interface UserService extends MessagingSystemConstantsIF
{
    MessagingSystemUser findUser(String userId);

    void registerUser(MessagingSystemUser newUser);

    void removeUser(String userId);

}
