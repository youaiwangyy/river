package com.youai.river.util;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

/**
 * Created by Qingjiang Li on 2017/8/3.
 */
public class CommonStringUtilTest {

    @Test
    public void testStringFormat() {
        String sql = "select * from user where id = ? and status = ? limit ? , ?";
        System.out.println(sql);
        List<String> params = Lists.newArrayList("1001", "1", "10", "20");
        String result = CommonStringUtil.formatString(sql, params.toArray());
        System.out.println(result);

    }
}
