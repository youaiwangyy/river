package com.youai.river.dao.db;

import com.alibaba.fastjson.JSONObject;
import com.youai.river.common.enums.SexEnum;
import com.youai.river.common.enums.UserStatusEnum;
import com.youai.river.dao.UserDao;
import com.youai.river.po.user.User;
import com.youai.river.util.ApiLogger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by Qingjiang Li on 2017/7/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/commons/mvc-dispatcher-servlet.xml")
public class UserDaoTest {

    @Resource
    private UserDao userDao;

    @Test
    public void saveUser() {
        User user = new User();
        user.setUsername("Ting Feng");
        user.setPassword("123456");
        user.setSex(SexEnum.FEMALE.getId());
        user.setStatus(UserStatusEnum.NORMAL.getId());
        user.setBirthday(new Date().getTime());
        user.setCreateTime(new Date().getTime());
        user.setUpdateTime(new Date().getTime());

        boolean save = userDao.saveUser(user);
        System.out.println("save:" + save);
    }

    @Test
    public void deleteUserById() {
        long id = 1L;
        boolean del = userDao.deleteUserByUid(id);
        System.out.println("del:" + del);
    }

    @Test
    public void updateUserPasswordById() {
        boolean update = userDao.updateUserPasswordByUid(6, "wangguang");
        System.out.println("update:" + update);
    }

    @Test
    public void queryOneUser() {
        User user = userDao.queryUserByUid(6);
        System.out.println(JSONObject.toJSONString(user));
    }

    @Test
    public void queryUserBatch() {
        List<User> users = userDao.queryUserBySex(SexEnum.FEMALE.getId());
        ApiLogger.info("userList:" + JSONObject.toJSONString(users));

    }

}
