package com.jjw.messagingsystem.security.google;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

import com.google.appengine.api.users.User;
import com.jjw.messagingsystem.dto.UdacityUser;
import com.jjw.messagingsystem.security.udacity.UdacityUserAuthentication;
import com.jjw.messagingsystem.security.util.AppRole;
import com.jjw.messagingsystem.service.UserService;

public class GoogleAccountsAuthenticationProvider implements AuthenticationProvider
{
    @Autowired
    private UserService myUserService;

    public Authentication authenticate(Authentication authentication) throws AuthenticationException
    {
        User googleUser = (User) authentication.getPrincipal();

        UdacityUser user = myUserService.findUser(googleUser.getUserId());

        if (user == null)
        {
            // User not in registry. Needs to register and add the NEW_USER role
            Set<AppRole> authorities = new HashSet<AppRole>();
            authorities.add(AppRole.NEW_USER);
            user = new UdacityUser(googleUser.getUserId(), googleUser.getNickname(), googleUser.getEmail(), authorities);
        }

        if (!user.isEnabled())
        {
            throw new DisabledException("Account is disabled");
        }

        return new UdacityUserAuthentication(user, authentication.getDetails());
    }

    public final boolean supports(Class<?> authentication)
    {
        return PreAuthenticatedAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
