package com.jjw.messagingsystem.dto;

import com.jjw.messagingsystem.util.TimeUtil;

public class MessageDTO
{
    private Long myMessageId;
    private String myToUserName;
    private String myFromUserName;
    private String myContent;
    private boolean myIsRead;
    private String mySubject;
    private String myDate;

    public MessageDTO()
    {
    }

    public MessageDTO(Long messageId, String toUserName, String fromUserName, String content, String subject)
    {
        myMessageId = messageId;
        myToUserName = toUserName;
        myFromUserName = fromUserName;
        myContent = content;
        myDate = TimeUtil.getCurrentTimeHumanReadable();
        mySubject = subject;
        myIsRead = false;
    }

    public MessageDTO(String toUserName, String fromUserName, String content, String subject)
    {
        myToUserName = toUserName;
        myFromUserName = fromUserName;
        myContent = content;
        mySubject = subject;
        myDate = TimeUtil.getCurrentTimeHumanReadable();
        myIsRead = false;
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

    /**
     * @return the isRead
     */
    public boolean isIsRead()
    {
        return myIsRead;
    }

    /**
     * @param isRead the isRead to set
     */
    public void setIsRead(boolean isRead)
    {
        myIsRead = isRead;
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
