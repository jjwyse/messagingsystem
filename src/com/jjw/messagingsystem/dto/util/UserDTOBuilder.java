package com.jjw.messagingsystem.dto.util;

import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.util.Assert;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.jjw.messagingsystem.dto.UserDTO;
import com.jjw.messagingsystem.security.util.AppRole;

public class UserDTOBuilder extends MessagingSystemDTOBuilder
{
    public static UserDTO fromEntity(Entity userEntity)
    {
        Assert.notNull(userEntity, "User entity cannot be null");

        UserDTO userDTO = new UserDTO();

        userDTO.setUserName((String) userEntity.getProperty(USER_USERNAME));
        userDTO.setFirstName((String) userEntity.getProperty(USER_FIRSTNAME));
        userDTO.setLastName((String) userEntity.getProperty(USER_LASTNAME));
        userDTO.setEmail((String) userEntity.getProperty(USER_EMAIL));
        userDTO.setEnabled((boolean) userEntity.getProperty(USER_ENABLED));

        long binaryAuthorities = (Long) userEntity.getProperty(USER_AUTHORITIES);
        Set<AppRole> roles = EnumSet.noneOf(AppRole.class);
        for (AppRole r : AppRole.values())
        {
            if ((binaryAuthorities & (1 << r.getBit())) != 0)
            {
                roles.add(r);
            }
        }
        userDTO.setAuthorities(roles);

        return userDTO;
    }

    public static Entity toEntity(UserDTO newUser)
    {
        Assert.notNull(newUser, "User DTO cannot be null");

        // Key off of the user name. User name is unique for that user
        Key key = KeyFactory.createKey(USER_TYPE, newUser.getUserName());

        Entity user = new Entity(key);
        user.setProperty(USER_EMAIL, newUser.getEmail());
        user.setProperty(USER_USERNAME, newUser.getUserName());
        user.setProperty(USER_FIRSTNAME, newUser.getFirstName());
        user.setProperty(USER_LASTNAME, newUser.getLastName());
        user.setUnindexedProperty(USER_ENABLED, newUser.isEnabled());

        Collection<? extends GrantedAuthority> roles = newUser.getAuthorities();
        long binaryAuthorities = 0;
        for (GrantedAuthority r : roles)
        {
            binaryAuthorities |= 1 << ((AppRole) r).getBit();
        }
        user.setUnindexedProperty(USER_AUTHORITIES, binaryAuthorities);

        return user;
    }
}
