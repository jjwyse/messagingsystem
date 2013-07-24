package com.jjw.messagingsystem.form.compose;

/**
 * Compose form used for the user to send messages
 * 
 * @author jjwyse
 * 
 */
public class ComposeForm
{
    @ToUserName
    private String myToUserName;

    @Content
    private String myContent;

    @Subject
    private String mySubject;

    @ToGroupName
    private String myToGroupName;

    /**
     * @return the toUserName
     */
    public String getToUserName()
    {
        return myToUserName;
    }

    /**
     * @param toUserName the toUserName to set
     */
    public void setToUserName(String toUserName)
    {
        myToUserName = toUserName;
    }

    /**
     * @return the content
     */
    public String getContent()
    {
        return myContent;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content)
    {
        myContent = content;
    }

    /**
     * @return the subject
     */
    public String getSubject()
    {
        return mySubject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject)
    {
        mySubject = subject;
    }

    /**
     * @return the groupName
     */
    public String getToGroupName()
    {
        return myToGroupName;
    }

    /**
     * @param groupName the groupName to set
     */
    public void setToGroupName(String toGroupName)
    {
        myToGroupName = toGroupName;
    }
}
