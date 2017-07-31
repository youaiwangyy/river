package com.youai.river.service.impl;

import com.youai.river.cache.UserCache;
import com.youai.river.dao.UserDao;
import com.youai.river.po.user.User;
import com.youai.river.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Qingjiang Li on 2017/7/24.
 */
@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Resource
    private UserCache userCache;

    @Override
    public User getUserById(long id) {
        User user = userCache.getUserById(id);
        if (user == null) {
            user = userDao.queryUserByUid(id);
            if (user != null) {
                userCache.addUser(user);
            }
        }
        return user;
    }
}
