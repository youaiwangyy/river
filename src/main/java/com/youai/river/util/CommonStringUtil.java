package com.youai.river.util;

/**
 * Created by Qingjiang Li on 2017/8/3.
 */
public class CommonStringUtil {

    /**
     * 格式化字符串，把？对应到指定的值
     * @param str
     * @param args
     * @return
     */
    public static String formatString(String str, Object ... args) {
        return formatString(str, "\\?", args);
    }

    /**
     * 把指定模式的字符串格式化指定类型
     * @param str str
     * @param partten partten
     * @param args args
     * @return string
     */
    public static String formatString(String str, String partten, Object ... args) {
        String rep = str.replaceAll(partten, "%s");
        return String.format(rep, args);
    }

    /**
     * 统计字符串str中包含字符串s的个数
     * @param str str
     * @param s s
     * @return int
     */
    public static int containsCount(String str, String s) {
        int r = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.indexOf(s, i) != -1) {
                i = str.indexOf(s, i);
                r++;
            }
        }
        return r;
    }
}
