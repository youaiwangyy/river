package com.youai.river.cache.mongo;

import com.youai.river.base.mongo.AbstractMongoBaseDao;
import com.youai.river.po.user.User;
import org.springframework.stereotype.Repository;

/**
 * Created by Qingjiang Li on 2017/8/2.
 */
@Repository(value = "mongoUserDao")
public class MongoUserDao extends AbstractMongoBaseDao<User> {



}
