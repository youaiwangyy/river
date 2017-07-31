package com.youai.river.util;

import java.util.regex.Pattern;

/**
 * Created by Qingjiang Li on 2017/7/20.
 */
public class CommonNumberUtil {


    /**
     * 判断str是否是数字，包含负数
     * @param str str
     * @return boolean 返回str是否是数字
     */
    public static boolean isNumber(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

}
