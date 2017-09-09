package com.youai.river.dao.cache;

import com.youai.river.cache.mongo.MongoUserDao;
import com.youai.river.cache.redis.RedisUserCache;
import com.youai.river.po.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.mongodb.core.query.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Qingjiang Li on 2017/7/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/commons/mvc-dispatcher-servlet.xml")
public class UserCacheTest {

    @Resource
    private RedisUserCache redisUserCache;

    @Resource
    private MongoUserDao mongoUserDao;

    @Test
    public void testRedis() {
        String name = redisUserCache.getUserName("name");
        System.out.println("name:" + name);
    }

    @Test
    public void testMongo() {
        long current = System.currentTimeMillis();
        User user = new User();
        user.setId(100002L);
        user.setUsername("Qingjiang Li");
        user.setPassword("liqingjiang");
        user.setSex(1);
        user.setStatus(1);
        user.setBirthday(current);
        user.setUpdateTime(current);
        user.setCreateTime(current);

        System.out.println("user:" + user);
        User add = mongoUserDao.add(user);
        System.out.println("add:" + add);

    }

    @Test
    public void testMongoUpdateAll() {
        Criteria criteria = Criteria.where("id").is(100001L);
        Query query = Query.query(criteria);
        BasicUpdate update = new BasicUpdate("{$unset:{_class:1}}");
        User user = mongoUserDao.findAndUpdate(query, update);
        System.out.println(user);

    }


}
