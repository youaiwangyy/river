package com.youai.river.data;

import com.youai.river.po.user.User;

import java.util.List;

/**
 * Created by Qingjiang Li on 2017/8/2.
 */
public abstract class WashDataService {

    public void doWashData(){
        List<User> data = getData();
        //TODO 具体实现 insert data
    }

    public abstract List<User> getData();

}
