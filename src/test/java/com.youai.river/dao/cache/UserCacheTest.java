package com.youai.river.dao.cache;

import com.youai.river.cache.redis.RedisUserCache;
import org.junit.Test;
import org.junit.runner.RunWith;
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

    @Test
    public void testRedis() {
        String name = redisUserCache.getUserName("name");
        System.out.println("name:" + name);
    }

}
