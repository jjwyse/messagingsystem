package com.jjw.messagingsystem.security.googleappengine;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import com.jjw.messagingsystem.dto.UserDTO;

/**
 * Authentication object representing a fully-authenticated user.
 * 
 * @author Luke Taylor
 */
public class GoogleAppEngineUserAuthentication implements Authentication
{
    private final UserDTO myPrincipal;
    private final Object myDetails;
    private boolean myAuthenticated;

    public GoogleAppEngineUserAuthentication(UserDTO principal, Object details)
    {
        this.myPrincipal = principal;
        this.myDetails = details;
        myAuthenticated = true;
    }

    public Collection<GrantedAuthority> getAuthorities()
    {
        return new HashSet<GrantedAuthority>(myPrincipal.getAuthorities());
    }

    public Object getCredentials()
    {
        throw new UnsupportedOperationException();
    }

    public Object getDetails()
    {
        return null;
    }

    public Object getPrincipal()
    {
        return myPrincipal;
    }

    public boolean isAuthenticated()
    {
        return myAuthenticated;
    }

    public void setAuthenticated(boolean isAuthenticated)
    {
        myAuthenticated = isAuthenticated;
    }

    public String getName()
    {
        return myPrincipal.getUserName();
    }

    @Override
    public String toString()
    {
        return this.getClass().getName() + "{" + "principal=" + myPrincipal + ", details=" + myDetails
                + ", authenticated=" + myAuthenticated + '}';
    }
}
