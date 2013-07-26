package com.jjw.messagingsystem.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Time utility class to provide common time functions
 * 
 * @author jjwyse
 * 
 */
public class TimeUtil
{
    /** The format for our time in the system. */
    private static SimpleDateFormat myFormatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

    /**
     * Gets the current time in milliseconds
     * 
     * @return current time in milliseconds
     */
    public static Long getCurrentTime()
    {
        return new Long(System.currentTimeMillis());
    }

    /**
     * Gets the current time in String format
     * 
     * @return The current time in human readable, String format
     */
    public static String getCurrentTimeHumanReadable()
    {
        Date date = new Date();
        return myFormatter.format(date);
    }

    /**
     * Allows other classes to reuse our date formatter
     * 
     * @return The date formatter
     */
    public static DateFormat getDateFormatter()
    {
        return myFormatter;
    }
}
