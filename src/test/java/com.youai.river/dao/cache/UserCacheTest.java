package com.youai.river.dao.cache;

import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.youai.river.cache.mongo.MongoUserDao;
import com.youai.river.cache.redis.RedisUserCache;
import com.youai.river.po.user.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.mongodb.core.query.BasicUpdate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

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
    public void testMongo() throws Exception {
        long current = System.currentTimeMillis();
        User user = new User();
        user.setId(1200003L);
        user.setUsername("Qingjiang Li");
        user.setPassword("liqingjiang");
        user.setSex(1);
        user.setStatus(1);
        user.setBirthday(current);
        user.setUpdateTime(current);
        user.setCreateTime(current);

        List<User> users = Lists.newArrayList();
        for (int i=0; i<1000000; i++) {
            User uc = (User)BeanUtils.cloneBean(user);
            uc.setId(user.getId() + i);
            users.add(uc);
        }
        long start = System.currentTimeMillis();
        mongoUserDao.addBatch(users);
        System.out.println("time: " + (System.currentTimeMillis() - start));

    }

    @Test
    public void testMongoUpdateAll() {
        Criteria criteria = Criteria.where("id").is(100001L);
        Query query = Query.query(criteria);
        BasicUpdate update = new BasicUpdate("{$unset:{_class:1}}");
        User user = mongoUserDao.findAndUpdate(query, update);
        System.out.println(user);

    }

    @Test
    public void testFind(){
        Criteria criteria = Criteria.where("id").gte(100001L);
        Query query = Query.query(criteria);

        List<User> userList = mongoUserDao.findByQuery(query, 10, 0);
        System.out.println(JSONObject.toJSONString(userList));
    }

    @Test
    public void testUpdate(){
        Criteria criteria = Criteria.where("id").gte(100000);
        Query query = Query.query(criteria);
        BasicUpdate update = new BasicUpdate("{$push:{hobbies:{$each:['dog','cat','run', 'basketball']}}}");
        mongoUserDao.updateAll(query, update);

    }


}
