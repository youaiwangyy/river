package com.youai.river.test;

import com.google.common.base.Optional;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Qingjiang Li on 2017/8/4.
 */
public class GuavaTest {

    @Test
    public void testOptional2() {
        String str = "";
        Optional<String> possible = Optional.of(str);
        if(possible.isPresent()){
            System.out.println("possible isPresent:"+possible.isPresent());
            System.out.println("possible value:"+possible.get());
        }
    }

    @Test
    public void testOptional() throws Exception{
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("url", "user", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String catalog = conn.getCatalog();
    }
}
