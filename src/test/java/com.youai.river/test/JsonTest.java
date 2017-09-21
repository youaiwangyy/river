package com.youai.river.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Qingjiang Li on 2017/7/26.
 */
public class JsonTest {

    @Test
    public void testSet() {
        Set<Long> set = Sets.newHashSet(202045805466L);
        System.out.println(JSONObject.toJSONString(set));
    }

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

    @Test
    public void testJsonp() {
        StringBuilder sb = new StringBuilder("{'name':'liqingjiang','status':1}");
        System.out.println(JSONObject.parse(sb.toString()));

        System.out.println(sb.toString());


    }
    @Test
    public void testJson() {
        String ids = "[123,123,234]";
        JSONArray idArray = JSONObject.parseArray(ids);
        System.out.println(idArray);

    }

}
