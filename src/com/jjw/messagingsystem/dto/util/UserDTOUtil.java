package com.jjw.messagingsystem.dto.util;

import org.springframework.util.Assert;

import com.google.appengine.api.datastore.Entity;
import com.jjw.messagingsystem.dto.UserDTO;

public class UserDTOUtil extends MessagingSystemDTOBuilder
{
    public static Entity toEntity(UserDTO user)
    {
        Assert.notNull(user, "UserDTO was null, cannot create Entity");

        Entity entity = new Entity(ENTITY_USER, user.getUserName());
        entity.setProperty(ENTITY_PROP_FIRST_NAME, user.getFirstName());
        entity.setProperty(ENTITY_PROP_LAST_NAME, user.getLastName());
        entity.setProperty(ENTITY_PROP_USERNAME, user.getUserName());
        entity.setProperty(ENTITY_PROP_EMAIL, user.getEmail());

        return entity;
    }

    public static UserDTO fromEntity(Entity entity)
    {
        Assert.notNull(entity, "Entity was null, cannot create User");

        String firstName = (String) entity.getProperty(ENTITY_PROP_FIRST_NAME);
        String lastName = (String) entity.getProperty(ENTITY_PROP_LAST_NAME);
        String userName = (String) entity.getProperty(ENTITY_PROP_USERNAME);
        String email = (String) entity.getProperty(ENTITY_PROP_EMAIL);

        return new UserDTO(firstName, lastName, userName, email);
    }
}
