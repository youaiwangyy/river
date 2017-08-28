package com.youai.river.test;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.*;

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

        List<Long> list = Lists.newArrayList(1001L, 1002L, 1003L);
        for (long id : list) {
            map.remove(id);
        }

        Set<Object> singleton = Collections.singleton(null);
    }
}
