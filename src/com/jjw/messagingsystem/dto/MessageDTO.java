package com.jjw.messagingsystem.dto;

import java.text.ParseException;
import java.util.Date;
import java.util.logging.Logger;

import com.jjw.messagingsystem.util.TimeUtil;

/**
 * Message Data Transfer Object which represents a Message in our system.
 * 
 * @author jjwyse
 * 
 */
public class MessageDTO implements Comparable
{
    private static final Logger myLogger = Logger.getLogger(MessageDTO.class.getName());

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
    public boolean getIsRead()
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

    /**
     * {@inheritDoc}
     */
    @Override
    public int compareTo(Object other)
    {
        // if this is < otherMessageDto return -1 and so on ...
        if (!(other instanceof MessageDTO))
        {
            return -1;
        }
        MessageDTO otherMessageDTO = (MessageDTO) other;
        try
        {
            Date otherDate = TimeUtil.getDateFormatter().parse(otherMessageDTO.getDate());
            Date thisDate = TimeUtil.getDateFormatter().parse(getDate());
            if (thisDate.before(otherDate))
            {
                return -1;
            }
            else if (thisDate.after(otherDate))
            {
                return 1;
            }
            return 0;
        }
        catch (ParseException e)
        {
            myLogger.warning("Unable to parse one of these dates: other:" + otherMessageDTO.getDate() + ", this: "
                    + getDate());
        }

        return -1;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("MessageDTO [myMessageId=");
        builder.append(myMessageId);
        builder.append(", myToUserName=");
        builder.append(myToUserName);
        builder.append(", myFromUserName=");
        builder.append(myFromUserName);
        builder.append(", myToGroupName=");
        builder.append(myToGroupName);
        builder.append(", myContent=");
        builder.append(myContent);
        builder.append(", myIsRead=");
        builder.append(myIsRead);
        builder.append(", myDate=");
        builder.append(myDate);
        builder.append("]");
        return builder.toString();
    }
}
