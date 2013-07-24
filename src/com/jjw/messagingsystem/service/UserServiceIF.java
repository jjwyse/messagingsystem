package com.jjw.messagingsystem.service;

import com.jjw.messagingsystem.dto.UserDTO;

/**
 * Interface to the users in our system
 * 
 * @author jjwyse
 * 
 */
public interface UserServiceIF extends MessagingSystemServiceIF
{
    /**
     * Find the user object for this user name
     * 
     * @param userName The user name to retrieve the full user object for
     * @return The user data transfer object for this user name
     */
    UserDTO findUser(String userName);

    /**
     * Register a new user in our system
     * 
     * @param newUser The user to register
     */
    void registerUser(UserDTO newUser);

    /**
     * Remove a user from our system
     * 
     * @param userName The user to remove
     */
    void removeUser(String userName);

    /**
     * Check to see if a user exists in our system
     * 
     * @param userName The user to see if they exists
     * @return True if the user exists
     */
    boolean userExists(String userName);

}
