package com.youai.river.cache.redis;

import com.youai.river.base.redis.RedisClientTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by Qingjiang Li on 2017/8/29.
 */
@Repository(value = "redisUserCache")
public class RedisUserCache {

    @Resource
    private RedisClientTemplate redisClientTemplate;

    public String getUserName(String name) {
        String value = redisClientTemplate.get(name);
        return value;
    }


}
