/**
 * 
 */
package com.jjw.messagingsystem.security;

/**
 * @author jjwyse
 * 
 */
public interface UserRegistry
{
    GaeUser findUser(String userId);

    void registerUser(GaeUser newUser);

    void removeUser(String userId);
}
