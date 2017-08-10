package com.youai.river.data.info;

import com.youai.river.data.MerchantDataService;
import com.youai.river.po.user.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Qingjiang Li on 2017/8/2.
 */
@Service
public class MysqlTencentDataService implements MerchantDataService {

    @Override
    public List<User> getMerchantData() {
        //TODO 具体实现get data
        return null;
    }

}
