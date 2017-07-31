package com.youai.river.dao.impl;

import com.youai.river.dao.UserDao;
import com.youai.river.po.user.User;
import com.youai.river.util.ApiLogger;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Qingjiang Li on 2017/7/24.
 */
@Repository(value = "userDao")
public class UserDaoImpl implements UserDao {

    private static final String QUERY_ONE_UID = "select * from user where id = ?";
    private static final String QUERY_LIST_SEX = "select * from user where sex = ?";
    private static final String SAVE_USER = "insert into user (username, password, sex, status, birthday, create_time, update_time) values (?, ?, ?, ?, ?, ?, ?)";
    private static final String DELETE_USER_UID = "delete from user where id = ?";
    private static final String UPDATE_PASSWORD_UID = "update user set password = ? where id = ?";
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public User queryUserByUid(long id) {
        return jdbcTemplate.query(QUERY_ONE_UID, new Object[]{id}, (rs) -> {
            if (rs.next()) {
                return getUserByRs(rs);
            }
            return null;
        });
    }

    @Override
    public List<User> queryUserBySex(int sex) {
        return jdbcTemplate.query(QUERY_LIST_SEX, new Object[]{sex}, (rs, i) -> {
            return getUserByRs(rs);
        });
        /*RowMapper<User> rowMapper = new BeanPropertyRowMapper<>(User.class);
        return jdbcTemplate.query(QUERY_LIST_SEX, new Object[]{sexEnum.getId()}, rowMapper);*/
    }

    @Override
    public boolean saveUser(User user) {
        return jdbcTemplate.update(SAVE_USER, new Object[]{
                user.getUsername(),
                user.getPassword(),
                user.getSex(),
                user.getStatus(),
                user.getBirthday(),
                user.getCreateTime(),
                user.getUpdateTime()
        }) >= 1;
    }

    @Override
    public boolean deleteUserByUid(long id) {
        return jdbcTemplate.update(DELETE_USER_UID, new Object[]{id}) >= 1;
    }

    @Override
    public boolean updateUserPasswordByUid(long id, String password) {
        return jdbcTemplate.update(UPDATE_PASSWORD_UID, new Object[]{password, id}) >= 1;
    }


    private User getUserByRs(ResultSet rs) throws SQLException {
        if (rs != null) {
            try {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setSex(rs.getInt("sex"));
                user.setStatus(rs.getInt("status"));
                user.setBirthday(rs.getLong("birthday"));
                user.setCreateTime(rs.getLong("create_time"));
                user.setUpdateTime(rs.getLong("update_time"));
                return user;
            } catch (Exception e) {
                ApiLogger.error("Format user by result set error", e);
            }
        }
        return null;
    }
}
