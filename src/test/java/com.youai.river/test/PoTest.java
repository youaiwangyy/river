package com.youai.river.test;

import com.google.common.collect.Lists;
import com.youai.river.po.user.User;
import org.junit.Test;

import java.util.List;

/**
 * Created by Qingjiang Li on 2017/7/27.
 */
public class PoTest {


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
