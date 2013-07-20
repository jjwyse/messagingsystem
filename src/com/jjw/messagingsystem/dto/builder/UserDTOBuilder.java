package com.jjw.messagingsystem.dto.builder;

import org.springframework.util.Assert;

import com.google.appengine.api.datastore.Entity;
import com.jjw.messagingsystem.dto.UserDTO;

public class UserDTOBuilder extends MessagingSystemDTOBuilder
{
    public static Entity toEntity(UserDTO user)
    {
        Assert.notNull(user, "UserDTO was null, cannot create Entity");

        Entity entity = new Entity(ENTITY_USER);
        entity.setProperty(ENTITY_PROP_FIRST_NAME, user.getFirstName());
        entity.setProperty(ENTITY_PROP_LAST_NAME, user.getLastName());
        entity.setProperty(ENTITY_PROP_USERNAME, user.getUserName());

        return entity;
    }

    public static UserDTO fromEntity(Entity entity)
    {
        Assert.notNull(entity, "Entity was null, cannot create User");

        UserDTO user = new UserDTO();
        entity.getProperty(ENTITY_PROP_FIRST_NAME);
        entity.getProperty(ENTITY_PROP_LAST_NAME);
        entity.getProperty(ENTITY_PROP_USERNAME);

        return user;
    }
}
