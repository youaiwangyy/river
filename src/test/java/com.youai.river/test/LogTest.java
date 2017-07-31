package com.youai.river.test;

import com.youai.river.util.ApiLogger;
import org.junit.Test;

/**
 * Created by Qingjiang Li on 2017/7/24.
 */
public class LogTest {

    @Test
    public void testLogInfo() {
        ApiLogger.info("Info Info");
        ApiLogger.error("Error Error");
        ApiLogger.debug("Debug Debug");

    }

}
