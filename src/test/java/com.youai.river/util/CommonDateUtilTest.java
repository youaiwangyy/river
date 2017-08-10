package com.youai.river.util;

import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Qingjiang Li on 2017/8/8.
 */
public class CommonDateUtilTest {

    @Test
    public void testDate() {
        long current = System.currentTimeMillis();
        Date date = CommonDateUtil.getCurrentMonday(current);
        System.out.println(date);
        String dateStr = CommonDateUtil.dateToString(date);
        System.out.println(dateStr);
        date = CommonDateUtil.getCurrentMonday();
        System.out.println(date);
        dateStr = CommonDateUtil.dateToString(date);
        System.out.println(dateStr);
        date = CommonDateUtil.formatToDay(date);
        System.out.println(date);
        dateStr = CommonDateUtil.dateToString(date);
        System.out.println(dateStr);
        date = CommonDateUtil.getCurrentSunday();
        System.out.println(date);
        dateStr = CommonDateUtil.dateToString(date);
        System.out.println(dateStr);
        date = CommonDateUtil.getCurrentWeek(Calendar.FRIDAY);
        System.out.println(date);
        dateStr = CommonDateUtil.dateToString(date);
        System.out.println(dateStr);
    }

}
