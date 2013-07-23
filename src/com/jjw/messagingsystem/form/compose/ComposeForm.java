package com.jjw.messagingsystem.form.compose;

public class ComposeForm
{
    @ToUserName
    private String myToUserName;

    @Content
    private String myContent;

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

}
