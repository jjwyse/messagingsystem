package com.jjw.messagingsystem.dto.builder;

import org.springframework.util.Assert;

import com.google.appengine.api.datastore.Entity;
import com.jjw.messagingsystem.dto.UserDTO;

public class UserDTOBuilder extends MessagingSystemDTOBuilder
{
    public static Entity toEntity(UserDTO user)
    {
        Assert.notNull(user, "UserDTO cannot be null");

        Entity entity = new Entity(ENTITY_USER);
        entity.setProperty(ENTITY_PROP_FIRST_NAME, user.getFirstName());
        entity.setProperty(ENTITY_PROP_LAST_NAME, user.getLastName());
        entity.setProperty(ENTITY_PROP_NICK_NAME, user.getNickName());

        return entity;
    }

    public static UserDTO fromEntity(Entity entity)
    {
        UserDTO user = new UserDTO();
        // TODO
        return user;
    }

}
