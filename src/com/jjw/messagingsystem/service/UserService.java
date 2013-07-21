package com.jjw.messagingsystem.service;

import com.jjw.messagingsystem.MessagingSystemConstantsIF;
import com.jjw.messagingsystem.dto.GoogleAppEngineUser;

public interface UserService extends MessagingSystemConstantsIF
{
    GoogleAppEngineUser findUser(String userId);

    void registerUser(GoogleAppEngineUser newUser);

    void removeUser(String userId);

}
