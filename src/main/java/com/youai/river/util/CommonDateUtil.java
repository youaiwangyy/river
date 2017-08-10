package com.youai.river.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Qingjiang Li on 2017/7/24.
 */
public class CommonDateUtil {

    public static final SimpleDateFormat sdf_yyyyMM = new SimpleDateFormat("yyyyMM");
    public static final SimpleDateFormat sdf_yyyyMMdd = new SimpleDateFormat("yyyyMMdd");
    public static final SimpleDateFormat sdf_yyyy_MM_dd_HH_mm_ss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat sdf_yyyy_MM_dd = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat sdf_yyyyMMddHH = new SimpleDateFormat("yyyyMMddHH");
    public static final SimpleDateFormat sdf_yyyy_MM_dd_HH = new SimpleDateFormat("yyyy-MM-dd HH");


    /**
     * 日期时间 格式化
     */
    public static final String TIMESTAMP = "yyyy-MM-dd HH:mm:ss";


    public static String dateToString(Date date) {
        return dateToString(date, sdf_yyyy_MM_dd_HH_mm_ss);
    }


    public static String dateToString(Date date, String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        return dateToString(date, sdf);
    }

    public static String dateToString(Date date, SimpleDateFormat sdf) {
        String returnValue = "";
        if (date != null && sdf != null)
        {
            returnValue = sdf.format(date);
        }
        return returnValue;
    }

    public static Date strToDate(String str) {
        return strToDate(str, sdf_yyyy_MM_dd_HH_mm_ss);
    }
    /**
     * 把时间格式的str转换到Date
     * @param str 日期字符串
     * @param dateFormat  日期格式
     * @return Date
     */
    public static Date strToDate(String str, String dateFormat) {
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        return strToDate(str, format);
    }

    /**
     * 把时间格式的str转换到Date
     * @param str
     * @param sdf
     * @return
     */
    public static Date strToDate(String str, SimpleDateFormat sdf) {
        Date date = null;
        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 时间去掉时分秒
     * @param date date
     * @return Date
     */
    public static Date formatToDay(Date date) {
        String format = dateToString(date, sdf_yyyy_MM_dd);
        return strToDate(format, sdf_yyyy_MM_dd);
    }

    /**
     * 获取指定毫秒时间的Date
     * @param currentTimeMillis timeMillis
     * @return Date
     */
    public static Date getCurrentMonday(long currentTimeMillis) {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.setTimeInMillis(currentTimeMillis);
        return calendar.getTime();
    }

    public static Date getCurrentMonday() {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return calendar.getTime();
    }

    public static Date getCurrentSunday() {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        return calendar.getTime();
    }

    public static Date getCurrentWeek(int week) {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.setFirstDayOfWeek(Calendar.MONDAY);
        calendar.set(Calendar.DAY_OF_WEEK, week);
        return calendar.getTime();
    }

    public static long getCurrentSecond() {
        return System.currentTimeMillis() / 1000;
    }

}
