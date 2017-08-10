package com.youai.river.data.job;


import com.youai.river.data.WashDataService;
import com.youai.river.data.db.MySqlDataSource;
import com.youai.river.data.info.MysqlTencentDataService;
import com.youai.river.po.user.User;

import java.util.List;

/**
 * Created by Qingjiang Li on 2017/8/2.
 */
public class MysqlTencentDataJob extends WashDataService {

    private MySqlDataSource mysqlDataSource;

    private MysqlTencentDataService mysqlTencentDataService;

    @Override
    public List<User> getData() {
        List<User> data = mysqlDataSource.getMerchantData(mysqlTencentDataService);
        return data;
    }

}
