package com.youai.river.service;

import com.youai.river.po.user.User;

/**
 * Created by Qingjiang Li on 2017/7/20.
 */
public interface UserService {

    /**
     * 根据用户ID获取用户信息
     * @param id id
     * @return user
     */
    public User getUserById(long id);

}
