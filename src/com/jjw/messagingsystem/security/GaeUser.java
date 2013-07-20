/**
 * 
 */
package com.jjw.messagingsystem.security;

import java.io.Serializable;
import java.util.Set;

/**
 * @author jjwyse
 * 
 */
public class GaeUser implements Serializable
{
    /** Serial ID */
    private static final long serialVersionUID = 1L;

    private String myUserId;
    private String myEmail;
    private String myNickname;
    private String myForename;
    private String mySurname;
    private Set<AppRole> myAuthorities;
    private boolean myEnabled;

    public GaeUser(String userId, String nickname, String email, String forename, String surname,
                    Set<AppRole> authorities, boolean isEnabled)
    {
        myUserId = userId;
        myEmail = email;
        myNickname = nickname;
        myForename = forename;
        mySurname = surname;
        myAuthorities = authorities;
        myEnabled = isEnabled;
    }

    /**
     * @param userId
     * @param nickname
     * @param email
     */
    public GaeUser(String userId, String nickname, String email)
    {
        myUserId = userId;
        myNickname = nickname;
        myEmail = email;
    }

    /**
     * @return the userId
     */
    public String getUserId()
    {
        return myUserId;
    }

    /**
     * @param userId
     *            the userId to set
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
     * @param email
     *            the email to set
     */
    public void setEmail(String email)
    {
        this.myEmail = email;
    }

    /**
     * @return the nickname
     */
    public String getNickname()
    {
        return myNickname;
    }

    /**
     * @param nickname
     *            the nickname to set
     */
    public void setNickname(String nickname)
    {
        this.myNickname = nickname;
    }

    /**
     * @return the forename
     */
    public String getForename()
    {
        return myForename;
    }

    /**
     * @param forename
     *            the forename to set
     */
    public void setForename(String forename)
    {
        this.myForename = forename;
    }

    /**
     * @return the surname
     */
    public String getSurname()
    {
        return mySurname;
    }

    /**
     * @param surname
     *            the surname to set
     */
    public void setSurname(String surname)
    {
        this.mySurname = surname;
    }

    /**
     * @return the authorities
     */
    public Set<AppRole> getAuthorities()
    {
        return myAuthorities;
    }

    /**
     * @param authorities
     *            the authorities to set
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
     * @param enabled
     *            the enabled to set
     */
    public void setEnabled(boolean enabled)
    {
        this.myEnabled = enabled;
    }
}
