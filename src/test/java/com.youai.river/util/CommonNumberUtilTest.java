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
        System.out.println("7:" + CommonNumberUtil.isNumber("+"));
        System.out.println("8:" + CommonNumberUtil.isNumber(""));
    }

    @Test
    public void testIsDecimal() {
        System.out.println("1:" + CommonNumberUtil.isDecimal("123"));
        System.out.println("2:" + CommonNumberUtil.isDecimal("+123"));
        System.out.println("3:" + CommonNumberUtil.isDecimal("-123"));
        System.out.println("4:" + CommonNumberUtil.isDecimal("0"));
        System.out.println("5:" + CommonNumberUtil.isDecimal("null"));
        System.out.println("6:" + CommonNumberUtil.isDecimal("abc"));
        System.out.println("7:" + CommonNumberUtil.isDecimal("-1.1"));
        System.out.println("8:" + CommonNumberUtil.isDecimal("-1."));
        System.out.println("9:" + CommonNumberUtil.isDecimal("-0.01"));
        System.out.println("10:" + CommonNumberUtil.isDecimal("1.1"));
        System.out.println("11:" + CommonNumberUtil.isDecimal("1."));
        System.out.println("12:" + CommonNumberUtil.isDecimal(".2"));
        System.out.println("13:" + CommonNumberUtil.isDecimal("-.2"));
        System.out.println("14:" + CommonNumberUtil.isDecimal("1.0"));
    }



}
