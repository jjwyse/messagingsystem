package com.jjw.messagingsystem.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil
{
    private static SimpleDateFormat myFormatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

    public static Long getCurrentTime()
    {
        return new Long(System.currentTimeMillis());
    }

    public static String getCurrentTimeHumanReadable()
    {
        Date date = new Date();
        return myFormatter.format(date);
    }
}
