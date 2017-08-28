package com.youai.river.test;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * Created by Qingjiang Li on 2017/8/28.
 */
public class FileTest {


    @Test
    public void testFileSame() throws Exception{
        File file1 = new File("D:\\Picture\\YG\\0.jpg");
        File file2 = new File("D:\\Picture\\YG\\1.jpg");

        File file3 = new File("E:\\Video\\0.mp4");
        File file4 = new File("E:\\Video\\1.mp4");


        FileInputStream fis1 = new FileInputStream(file1);
        FileInputStream fis2 = new FileInputStream(file2);

        String fileMD51 = getFileMD5(file1);
        String fileMD52 = getFileMD5(file2);
        System.out.println(fileMD51.equals(fileMD52));

    }
    // 计算文件的 MD5 值
    public static String getFileMD5(File file) {
        if (!file.isFile()) {
            return null;
        }
        MessageDigest digest = null;
        FileInputStream in = null;
        byte buffer[] = new byte[8192];
        int len;
        try {
            digest = MessageDigest.getInstance("MD5");
            in = new FileInputStream(file);
            while ((len = in.read(buffer)) != -1) {
                digest.update(buffer, 0, len);
            }
            BigInteger bigInt = new BigInteger(1, digest.digest());
            return bigInt.toString(16);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
