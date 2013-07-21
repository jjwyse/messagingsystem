package com.jjw.messagingsystem.security.udacity;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import com.jjw.messagingsystem.dto.UdacityUser;

/**
 * Authentication object representing a fully-authenticated user.
 * 
 * @author Luke Taylor
 */
public class UdacityUserAuthentication implements Authentication
{
    private final UdacityUser myPrincipal;
    private final Object myDetails;
    private boolean myAuthenticated;

    public UdacityUserAuthentication(UdacityUser principal, Object details)
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
        return myPrincipal.getUserId();
    }

    @Override
    public String toString()
    {
        return "GaeUserAuthentication{" + "principal=" + myPrincipal + ", details=" + myDetails + ", authenticated="
                + myAuthenticated + '}';
    }
}
