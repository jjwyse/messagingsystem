package com.jjw.messagingsystem.security.util;

import org.springframework.security.core.GrantedAuthority;

/**
 * Represents the different roles we can have in our messaging system.
 * 
 * With the help of SpringSource blog and @author Luke Fisher
 * 
 * @author jjwyse
 * 
 */
public enum MessagingSystemRole implements GrantedAuthority
{
    ADMIN(0), NEW_USER(1), USER(2);

    private int bit;

    MessagingSystemRole(int bit)
    {
        this.bit = bit;
    }

    public String getAuthority()
    {
        return toString();
    }

    public int getBit()
    {
        return this.bit;
    }
}