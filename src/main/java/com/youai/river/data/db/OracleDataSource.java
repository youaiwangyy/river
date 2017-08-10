package com.youai.river.data.db;

import com.youai.river.data.IDataSource;
import com.youai.river.data.MerchantDataService;
import com.youai.river.po.user.User;

import java.util.List;

/**
 * Created by Qingjiang Li on 2017/8/2.
 */
public class OracleDataSource implements IDataSource {

    @Override
    public List<User> getMerchantData(MerchantDataService merchantDataService) {
        return merchantDataService.getMerchantData();
    }
}
