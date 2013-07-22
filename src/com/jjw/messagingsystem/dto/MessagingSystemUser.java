/**
 * 
 */
package com.jjw.messagingsystem.dto;

import java.io.Serializable;
import java.util.Set;

import com.jjw.messagingsystem.security.util.AppRole;

/**
 * @author jjwyse
 * 
 */
public class MessagingSystemUser implements Serializable
{
    /** Serial ID */
    private static final long serialVersionUID = 1L;

    private String myUserId;
    private String myEmail;
    private String myUserName;
    private String myFirstName;
    private String myLastName;
    private Set<AppRole> myAuthorities;
    private boolean myEnabled = true;

    public MessagingSystemUser(String userId, String userName, String email, String firstName, String lastName,
            Set<AppRole> authorities, boolean isEnabled)
    {
        myUserId = userId;
        myEmail = email;
        myUserName = userName;
        myFirstName = firstName;
        myLastName = lastName;
        myAuthorities = authorities;
        myEnabled = isEnabled;
    }

    /**
     * @param userId
     * @param userName
     * @param email
     */
    public MessagingSystemUser(String userId, String userName, String email, Set<AppRole> authorities)
    {
        myUserId = userId;
        myUserName = userName;
        myEmail = email;
        myAuthorities = authorities;
    }

    /**
     * @return the userId
     */
    public String getUserId()
    {
        return myUserId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(String userId)
    {
        this.myUserId = userId;
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
    public Set<AppRole> getAuthorities()
    {
        return myAuthorities;
    }

    /**
     * @param authorities the authorities to set
     */
    public void setAuthorities(Set<AppRole> authorities)
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

    @Override
    public String toString()
    {
        return "MessagingSystemUser{" + "userId='" + myUserId + '\'' + ", userName='" + myUserName + '\''
                + ", firstName='" + myFirstName + '\'' + ", lastName='" + myLastName + '\'' + ", authorities="
                + myAuthorities + '}';
    }
}
