package com.youai.river.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * 统一日志处理
 * Created by Qingjiang Li on 2017/7/24.
 */
public class ApiLogger {

    private static final Logger DEBUG = LogManager.getLogger("debug");
    private static final Logger INFO = LogManager.getLogger("info");
    private static final Logger ERROR = LogManager.getLogger("error");
    private static final Logger REQUEST = LogManager.getLogger("request");
    private static final Logger DB_INFO = LogManager.getLogger("db_info");
    private static final Logger REVIEW_INFO = LogManager.getLogger("review_info");

    public static void debug(String message) {
        DEBUG.debug(message);
    }

    public static void info(String message) {
        INFO.info(message);
    }

    public static void error(String message) {
        ERROR.error(message);
    }

    public static void error(String message, Throwable throwable) {
        ERROR.error(message, throwable);
    }

    public static void dbInfo(String message) {
        DB_INFO.info(message);
    }

    public static void requset(String message) {
        REQUEST.info(message);
    }

    public static void reviewInfo(String message) {REVIEW_INFO.info(message);}

}
