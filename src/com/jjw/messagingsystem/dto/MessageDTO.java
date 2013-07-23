package com.jjw.messagingsystem.dto;


public class MessageDTO
{
    private Long myMessageId;
    private String myToUserName;
    private String myFromUserName;
    private String myContent;
    private String myDate;

    public MessageDTO()
    {
    }

    public MessageDTO(Long messageId, String toUserName, String fromUserName, String content, String date)
    {
        myMessageId = messageId;
        this.myToUserName = toUserName;
        this.myFromUserName = fromUserName;
        myContent = content;
        myDate = date;
    }

    /**
     * @return the messageId
     */
    public Long getMessageId()
    {
        return myMessageId;
    }

    /**
     * @param messageId the messageId to set
     */
    public void setMessageId(Long messageId)
    {
        myMessageId = messageId;
    }

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
        this.myToUserName = toUserName;
    }

    /**
     * @return the fromUserName
     */
    public String getFromUserName()
    {
        return myFromUserName;
    }

    /**
     * @param fromUserName the fromUserName to set
     */
    public void setFromUserName(String fromUserName)
    {
        this.myFromUserName = fromUserName;
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
     * @return the date
     */
    public String getDate()
    {
        return myDate;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date)
    {
        myDate = date;
    }

    @Override
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("MessageDTO (");
        stringBuilder.append("messageId: ").append(myMessageId);
        stringBuilder.append(", toUserName: ").append(myToUserName);
        stringBuilder.append(", fromUserName: ").append(myFromUserName);
        stringBuilder.append(", content: ").append(myContent);
        stringBuilder.append(", date: ").append(myDate);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
