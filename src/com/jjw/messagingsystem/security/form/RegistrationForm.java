/**
 * 
 */
package com.jjw.messagingsystem.security.form;

/**
 * 
 * @author jjwyse
 */
public class RegistrationForm
{
    @FirstName
    private String myFirstName;

    @LastName
    private String myLastName;

    @Groups
    private String myGroups;

    public String getFirstName()
    {
        return myFirstName;
    }

    public void setFirstName(String firstName)
    {
        this.myFirstName = firstName;
    }

    public String getLastName()
    {
        return myLastName;
    }

    public void setLastName(String lastName)
    {
        this.myLastName = lastName;
    }

    /**
     * @return the groups
     */
    public String getGroups()
    {
        return myGroups;
    }

    /**
     * @param groups the groups to set
     */
    public void setGroups(String groups)
    {
        myGroups = groups;
    }
}