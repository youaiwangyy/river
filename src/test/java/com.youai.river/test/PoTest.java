package com.youai.river.test;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.youai.river.po.user.User;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * Created by Qingjiang Li on 2017/7/27.
 */
public class PoTest {


    @Test
    public void testMap() {
        Map<String, String> map = Maps.newHashMap();
        map.put("name", "Qingjiang Li");
        map.put("sex", "1");
        map.put("address", "beijing");

        System.out.println(map);

        map.remove("name");
        System.out.println(map);

    }

    @Test
    public void testListPo() {
        User user1 = new User(1001, "Qingjiang Li", "123456");
        User user2 = new User(1002, "Jie Fang", "123456");
        User user3 = new User(1003, "Zijun Yu", "123456");
        List<User> userList = Lists.newArrayList(user1, user2, user3);

        List<User> users = userList.subList(0, 5);
        System.out.println(users);


    }



}
