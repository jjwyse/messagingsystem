package com.jjw.messagingsystem.dto;

public class UserDTO
{
    private String myFirstName;
    private String myLastName;
    private String myUserName;

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
        myFirstName = firstName;
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
        myLastName = lastName;
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
        myUserName = userName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString()
    {
        StringBuilder user = new StringBuilder();
        user.append("firstName: " + myFirstName).append(", ");
        user.append("lastName: " + myLastName).append(", ");
        user.append("userName: " + myUserName);
        return user.toString();
    }
}
