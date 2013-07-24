package com.jjw.messagingsystem.dao;

import com.jjw.messagingsystem.dto.UserDTO;

/**
 * User Data Access Object, providing an interface to our user data store
 * 
 * @author jjwyse
 * 
 */
public interface UserDAO
{
    /**
     * Find the specific user by this user name in our data store
     * 
     * @param userName The user we're searching for
     * @return The UserDTO for this username
     */
    UserDTO findUser(String userName);

    /**
     * Register a new user to our data store
     * 
     * @param newUser The new user to register
     */
    void registerUser(UserDTO newUser);

    /**
     * Remove a user from our data store
     * 
     * @param userName The user to un-register
     */
    void removeUser(String userName);

    /**
     * Check to see if a user is registered by this username
     * 
     * @param userName The username to see if they exist in our system
     * @return True if they exist
     */
    boolean userExists(String userName);
}
