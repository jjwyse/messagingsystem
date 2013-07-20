package com.jjw.messagingsystem.dto;

public class UserDTO
{
    private String myFirstName;
    private String myLastName;
    private String myUserName;
    private String myEmail;

    public UserDTO()
    {
    }

    public UserDTO(String firstName, String lastName, String userName, String email)
    {
        myFirstName = firstName;
        myLastName = lastName;
        myUserName = userName;
        myEmail = email;
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
        myEmail = email;
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
