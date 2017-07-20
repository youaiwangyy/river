package com.youai.river.po;

import com.youai.river.common.enums.SexEnum;

import java.io.Serializable;

/**
 * Created by Qingjiang Li on 2017/7/20.
 */
public class User implements Serializable {

    private long uid;
    private String username;
    private String password;
    private String address;
    private int sex = SexEnum.MALE.getId();//1:男 2：女 -1：未知

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }
}
