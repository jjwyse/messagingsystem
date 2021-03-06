package com.jjw.messagingsystem.dto.util;

import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.Assert;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.jjw.messagingsystem.dto.UserDTO;
import com.jjw.messagingsystem.security.util.MessagingSystemRole;

/**
 * Helps us transfer our User Data Transfer Objects to Google App Engine Entities and vice versa. Provide a common place
 * to do this to avoid having the same code everywhere
 * 
 * @author jjwyse
 * 
 */
public class UserDTOBuilder extends MessagingSystemDTOBuilder
{
    /**
     * Convert an entity into a User Data transfer object
     * 
     * @param userEntity The entity to convert to a User DTO
     * @return The User DTO representation of this entity
     */
    public static UserDTO fromEntity(Entity userEntity)
    {
        Assert.notNull(userEntity, "User entity cannot be null");

        UserDTO userDTO = new UserDTO();

        userDTO.setUserName((String) userEntity.getProperty(USERS_USERNAME));
        userDTO.setFirstName((String) userEntity.getProperty(USERS_FIRSTNAME));
        userDTO.setLastName((String) userEntity.getProperty(USERS_LASTNAME));
        userDTO.setEmail((String) userEntity.getProperty(USERS_EMAIL));
        userDTO.setGroups((List<String>) userEntity.getProperty(USERS_GROUPS));
        userDTO.setEnabled((boolean) userEntity.getProperty(USERS_ENABLED));

        long binaryAuthorities = (Long) userEntity.getProperty(USERS_AUTHORITIES);
        Set<MessagingSystemRole> roles = EnumSet.noneOf(MessagingSystemRole.class);
        for (MessagingSystemRole r : MessagingSystemRole.values())
        {
            if ((binaryAuthorities & (1 << r.getBit())) != 0)
            {
                roles.add(r);
            }
        }
        userDTO.setAuthorities(roles);

        return userDTO;
    }

    /**
     * Convert a UserDTO to a GAE entity object
     * 
     * @param newUser The user DTO to convert to a GAE entity
     * @return The GAE entity representation for this user DTO
     */
    public static Entity toEntity(UserDTO newUser)
    {
        Assert.notNull(newUser, "User DTO cannot be null");

        // Key off of the user name. User name is unique for that user
        Key key = KeyFactory.createKey(USERS_TYPE, newUser.getUserName());

        Entity user = new Entity(key);
        user.setProperty(USERS_EMAIL, newUser.getEmail());
        user.setProperty(USERS_USERNAME, newUser.getUserName());
        user.setProperty(USERS_FIRSTNAME, newUser.getFirstName());
        user.setProperty(USERS_LASTNAME, newUser.getLastName());
        user.setProperty(USERS_GROUPS, newUser.getGroups());
        user.setUnindexedProperty(USERS_ENABLED, newUser.isEnabled());

        Collection<? extends GrantedAuthority> roles = newUser.getAuthorities();
        long binaryAuthorities = 0;
        for (GrantedAuthority r : roles)
        {
            binaryAuthorities |= 1 << ((MessagingSystemRole) r).getBit();
        }
        user.setUnindexedProperty(USERS_AUTHORITIES, binaryAuthorities);

        return user;
    }
}
