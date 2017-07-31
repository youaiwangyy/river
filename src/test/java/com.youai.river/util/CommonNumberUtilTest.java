package com.youai.river.util;

import org.junit.Test;

/**
 * Created by Qingjiang Li on 2017/7/20.
 */
public class CommonNumberUtilTest {



    @Test
    public void testIsNumber() {
        System.out.println("1:" + CommonNumberUtil.isNumber("123"));
        System.out.println("2:" + CommonNumberUtil.isNumber("+123"));
        System.out.println("3:" + CommonNumberUtil.isNumber("-123"));
        System.out.println("4:" + CommonNumberUtil.isNumber("0"));
        System.out.println("5:" + CommonNumberUtil.isNumber("null"));
        System.out.println("6:" + CommonNumberUtil.isNumber(null));
        System.out.println("7:" + CommonNumberUtil.isNumber(""));
    }

}
