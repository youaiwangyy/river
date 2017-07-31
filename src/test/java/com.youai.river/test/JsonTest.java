package com.youai.river.test;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Qingjiang Li on 2017/7/26.
 */
public class JsonTest {

    @Test
    public void testJsonMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("age", 1);
        map.put("uid", 1001);
        map.put("count", 100);

        JSONObject json = new JSONObject();
        json.put("key", map.get("uid") == null ? 0 : map.get("uid"));
        System.out.println(json);


    }


}
