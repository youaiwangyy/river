package com.youai.river.test;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

/**
 * Created by Qingjiang Li on 2017/8/3.
 */
public class StringTest {

    @Test
    public void testStringOf() {
        String sql = "select * from user where id = %s and status = %s and sex = %s";
        List<String> params = Lists.newArrayList("1001", "1");
        String formatSql = String.format(sql, params.toArray());
        System.out.println(sql);
        System.out.println(formatSql);
    }

    @Test
    public void testStringReplace() {
        String sql = "select * from user where id = ?";
        String result = sql.replaceAll("\\?", "%s");
        System.out.println(result);
    }

}
