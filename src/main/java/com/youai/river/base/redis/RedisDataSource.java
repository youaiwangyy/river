package com.youai.river.base.redis;

import redis.clients.jedis.ShardedJedis;

/**
 * Created by Qingjiang Li on 2017/8/29.
 */
public interface RedisDataSource {

    public abstract ShardedJedis getRedisClient();
    public void returnResource(ShardedJedis shardedJedis);
    public void returnResource(ShardedJedis shardedJedis,boolean broken);

}
