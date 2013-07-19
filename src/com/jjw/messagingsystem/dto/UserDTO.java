package com.jjw.messagingsystem.dto;

public class UserDTO
{
    private String myFirstName;
    private String myLastName;
    private String myNickName;

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
     * @return the nickName
     */
    public String getNickName()
    {
        return myNickName;
    }

    /**
     * @param nickName the nickName to set
     */
    public void setNickName(String nickName)
    {
        myNickName = nickName;
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
        user.append("nickName: " + myNickName);
        return user.toString();
    }
}
