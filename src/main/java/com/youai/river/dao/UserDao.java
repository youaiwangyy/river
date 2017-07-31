package com.youai.river.dao;

import com.youai.river.po.user.User;

import java.util.List;

/**
 * Created by Qingjiang Li on 2017/7/20.
 */
public interface UserDao {

    User queryUserByUid(long id);

    List<User> queryUserBySex(int sex);

    boolean saveUser(User user);

    boolean deleteUserByUid(long id);

    boolean updateUserPasswordByUid(long id, String password);

}
