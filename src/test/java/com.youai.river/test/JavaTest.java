package com.youai.river.test;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.junit.Test;

/**
 * Created by Qingjiang Li on 2017/8/16.
 */
public class JavaTest {

    @Test
    public void test() {

        try{
            // 连接到 mongodb 服务
            MongoClient mongoClient = new MongoClient( "192.168.174.128" , 27017 );

            // 连接到数据库
            MongoDatabase mongoDatabase = mongoClient.getDatabase("user");
            System.out.println("Connect to database successfully");
            MongoIterable<String> strings = mongoDatabase.listCollectionNames();
            String first = strings.first();
            System.out.println(first);

        }catch(Exception e){
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }

    }


}
