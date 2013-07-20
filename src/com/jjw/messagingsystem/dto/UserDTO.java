package com.jjw.messagingsystem.dto;

public class UserDTO
{
    private String myFirstName;
    private String myLastName;
    private String myUserName;
    private String myPassword;
    private String myEmail;

    public UserDTO()
    {
    }

    public UserDTO(String firstName, String lastName, String userName, String password, String email)
    {
        myFirstName = firstName;
        myLastName = lastName;
        myUserName = userName;
        myPassword = password;
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
     * @return the password
     */
    public String getPassword()
    {
        return myPassword;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password)
    {
        myPassword = password;
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
