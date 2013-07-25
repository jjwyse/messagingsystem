package com.jjw.messagingsystem.dto;

import com.jjw.messagingsystem.util.TimeUtil;

/**
 * Message Data Transfer Object which represents a Message in our system.
 * 
 * @author jjwyse
 * 
 */
public class MessageDTO
{
    private Long myMessageId;
    private String myToUserName;
    private String myFromUserName;
    private String myToGroupName;
    private String myContent;
    private boolean myIsRead;
    private String myDate;

    public MessageDTO()
    {
    }

    public MessageDTO(Long messageId, String toUserName, String fromUserName, String content)
    {
        myMessageId = messageId;
        myToUserName = toUserName;
        myFromUserName = fromUserName;
        myContent = content;
        myDate = TimeUtil.getCurrentTimeHumanReadable();
        myIsRead = false;
    }

    public MessageDTO(String toUserName, String fromUserName, String content)
    {
        myToUserName = toUserName;
        myFromUserName = fromUserName;
        myContent = content;
        myDate = TimeUtil.getCurrentTimeHumanReadable();
        myIsRead = false;
    }

    public MessageDTO(String toUserName, String toGroupName, String fromUserName, String content)
    {
        myToUserName = toUserName;
        myFromUserName = fromUserName;
        myToGroupName = toGroupName;
        myContent = content;
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
     * @return the toGroupName
     */
    public String getToGroupName()
    {
        return myToGroupName;
    }

    /**
     * @param toGroupName the toGroupName to set
     */
    public void setToGroupName(String toGroupName)
    {
        myToGroupName = toGroupName;
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
