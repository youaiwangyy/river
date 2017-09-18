package com.youai.river.test;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Qingjiang Li on 2017/8/15.
 */
public class MapTest {



    @Test
    public void testMapRemove() {
        Map<Long, String> map = new HashMap<>();
        map.put(1001L, "str1001");
        map.put(1002L, "str1002");
        map.put(1003L, "str1003");
        map.put(1004L, "str1004");

        String val = map.getOrDefault(1001L, "not value");
        System.out.println("val:" + val);

        String val2 = map.getOrDefault(10021L, "not value");
        System.out.println("val:" + val2);
    }
}
