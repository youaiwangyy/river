package com.youai.river.cache;

import com.youai.river.po.user.User;
import org.springframework.stereotype.Repository;

/**
 * Created by Qingjiang Li on 2017/7/20.
 */
@Repository(value = "userCache")
public class UserCache {


    /**
     * 根据ID获取一个User from cache
     * @param id uid
     * @return user
     */
    public User getUserById(long id) {
        //TODO ...
        return null;
    }

    public boolean addUser(User user) {
        //TODO ...
        return true;
    }

}
