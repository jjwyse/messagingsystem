package com.jjw.messagingsystem.util;

import java.util.Date;

public class TimeUtil
{
    public static Long getCurrentTime()
    {
        return new Long(System.currentTimeMillis());
    }

    public static String getCurrentTimeHumanReadable()
    {
        Date date = new Date();
        return date.toString();
    }
}
