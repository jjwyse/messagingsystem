package com.jjw.messagingsystem.security.google;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

import com.google.appengine.api.users.User;
import com.jjw.messagingsystem.MessagingSystemConstantsIF;
import com.jjw.messagingsystem.dto.UserDTO;
import com.jjw.messagingsystem.security.googleappengine.GoogleAppEngineUserAuthentication;
import com.jjw.messagingsystem.security.util.MessagingSystemRole;
import com.jjw.messagingsystem.service.UserServiceIF;

/**
 * Handles our authentication with the google services.
 * 
 * @author jjwyse
 * 
 */
public class GoogleAccountsAuthenticationProvider implements AuthenticationProvider, MessagingSystemConstantsIF
{
    @Autowired
    private UserServiceIF myUserService;

    /**
     * Once the user has authenticated, we see if they exist in our system yet.
     */
    public Authentication authenticate(Authentication authentication) throws AuthenticationException
    {
        User googleUser = (User) authentication.getPrincipal();

        UserDTO user = myUserService.findUser(googleUser.getNickname());

        if (user == null)
        {
            // User not in registry. Needs to register and add the NEW_USER role
            Set<MessagingSystemRole> authorities = new HashSet<MessagingSystemRole>();
            authorities.add(MessagingSystemRole.NEW_USER);

            List<String> groups = new ArrayList<String>();
            groups.add(GROUP_ZE_WORLD);
            user = new UserDTO(googleUser.getNickname(), googleUser.getEmail(), authorities, groups);
        }

        if (!user.isEnabled())
        {
            throw new DisabledException("Account is disabled");
        }

        return new GoogleAppEngineUserAuthentication(user, authentication.getDetails());
    }

    /**
     * What classes are supportable
     */
    public final boolean supports(Class<?> authentication)
    {
        return PreAuthenticatedAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
