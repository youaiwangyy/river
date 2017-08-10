package com.youai.river.po;

import com.alibaba.fastjson.JSONObject;
import com.youai.river.po.user.User;
import com.youai.river.util.CommonDateUtil;
import org.junit.Test;

import java.util.Date;

/**
 * Created by Qingjiang Li on 2017/8/9.
 */
public class TestUser {

    @Test
    public void testUser() {
        long current = System.currentTimeMillis() / 1000;
        Date date = CommonDateUtil.strToDate("1991-12-23 12:00:00");
        long birthday = date.getTime() / 1000;
        User user = new User(1001, "Qingjiang Li", "123456", 1, 1, birthday, current, current);
        System.out.println(JSONObject.toJSONString(user));
        System.out.println("-------");
        user = new User(1002, "Keqiang Du", "123456", 1, 1, birthday, current, current);
        System.out.println(JSONObject.toJSONString(user));
        System.out.println("-------");
        user = new User(1003, "Yuliang Zhang", "123456", 1, 1, birthday, current, current);
        System.out.println(JSONObject.toJSONString(user));
        System.out.println("-------");
        user = new User(1004, "Yanhui Zhang", "123456", 1, 1, birthday, current, current);
        System.out.println(JSONObject.toJSONString(user));
        System.out.println("-------");
        user = new User(1005, "Yushun Cun", "123456", 1, 1, birthday, current, current);
        System.out.println(JSONObject.toJSONString(user));
        System.out.println("-------");
        user = new User(1006, "Penghua Liu", "123456", 1, 1, birthday, current, current);
        System.out.println(JSONObject.toJSONString(user));
        System.out.println("-------");
    }

}
