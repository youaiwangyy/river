package com.youai.river.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Qingjiang Li on 2017/7/24.
 */
public class CommonDateUtil {

    public static final SimpleDateFormat sdf_yyyyMM = new SimpleDateFormat(
            "yyyyMM");
    public static final SimpleDateFormat sdf_yyyyMMdd = new SimpleDateFormat(
            "yyyyMMdd");
    public static final SimpleDateFormat sdf_yyyy_MM_dd_HH_mm_ss = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss");
    public static final SimpleDateFormat sdf_yyyy_MM_dd = new SimpleDateFormat(
            "yyyy-MM-dd");
    public static final SimpleDateFormat sdf_yyyyMMddHH = new SimpleDateFormat(
            "yyyyMMddHH");
    public static final SimpleDateFormat sdf_yyyy_MM_dd_HH = new SimpleDateFormat(
            "yyyy-MM-dd HH");


    /**
     * 日期时间 格式化
     */
    public static final String TIMESTAMP = "yyyy-MM-dd HH:mm:ss";



    /**
     * 把时间格式的str转换到Date
     * @param str 日期字符串
     * @param dateFormat  日期格式
     * @return Date
     */
    public Date strToDate(String str, String dateFormat) {
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        Date date = null;
        try {
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

}
