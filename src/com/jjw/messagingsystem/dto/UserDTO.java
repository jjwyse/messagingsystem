/**
 * 
 */
package com.jjw.messagingsystem.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.jjw.messagingsystem.security.util.MessagingSystemRole;

/**
 * User Data Transfer Object which represents a User in our system
 * 
 * @author jjwyse
 * 
 */
public class UserDTO implements Serializable
{
    /** Serial ID */
    private static final long serialVersionUID = 1L;

    private String myEmail;
    private String myUserName;
    private String myFirstName;
    private String myLastName;
    private Set<MessagingSystemRole> myAuthorities;
    private List<String> myGroups;
    private boolean myEnabled = true;

    public UserDTO()
    {
    }

    public UserDTO(String userName, String email, String firstName, String lastName,
            Set<MessagingSystemRole> authorities, List<String> groups, boolean isEnabled)
    {
        myEmail = email;
        myUserName = userName;
        myFirstName = firstName;
        myLastName = lastName;
        myAuthorities = authorities;
        myGroups = groups;
        myEnabled = isEnabled;
    }

    /**
     * @param userId
     * @param userName
     * @param email
     */
    public UserDTO(String userName, String email, Set<MessagingSystemRole> authorities, List<String> groups)
    {
        myUserName = userName;
        myEmail = email;
        myAuthorities = authorities;
        myGroups = groups;
    }

    /**
     * @return the email
     */
    public String getEmail()
    {
        return myEmail;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email)
    {
        this.myEmail = email;
    }

    /**
     * @return the userName
     */
    public String getUserName()
    {
        return myUserName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName)
    {
        this.myUserName = userName;
    }

    /**
     * @return the firstName
     */
    public String getFirstName()
    {
        return myFirstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName)
    {
        this.myFirstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName()
    {
        return myLastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName)
    {
        this.myLastName = lastName;
    }

    /**
     * @return the authorities
     */
    public Set<MessagingSystemRole> getAuthorities()
    {
        return myAuthorities;
    }

    /**
     * @param authorities the authorities to set
     */
    public void setAuthorities(Set<MessagingSystemRole> authorities)
    {
        this.myAuthorities = authorities;
    }

    /**
     * @return the enabled
     */
    public boolean isEnabled()
    {
        return myEnabled;
    }

    /**
     * @param enabled the enabled to set
     */
    public void setEnabled(boolean enabled)
    {
        this.myEnabled = enabled;
    }

    /**
     * @return the groups
     */
    public List<String> getGroups()
    {
        return myGroups;
    }

    /**
     * @param groups the groups to set
     */
    public void setGroups(List<String> groups)
    {
        myGroups = groups;
    }

    @Override
    public String toString()
    {
        return "UserDTO{" + "userName='" + myUserName + '\'' + ", firstName='" + myFirstName + '\'' + ", lastName='"
                + myLastName + '\'' + ", authorities=" + myAuthorities + ", groups=" + myGroups + '}';
    }
}
