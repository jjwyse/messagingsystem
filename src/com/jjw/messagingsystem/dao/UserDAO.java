package com.jjw.messagingsystem.dao;

import com.jjw.messagingsystem.dto.GoogleAppEngineUser;

public interface UserDAO
{
    GoogleAppEngineUser findUser(String userId);

    void registerUser(GoogleAppEngineUser newUser);

    void removeUser(String userId);
}
