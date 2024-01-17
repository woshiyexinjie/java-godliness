package com.helloxin.sql;

import com.helloxin.util.RandomUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by nandiexin on 2019/5/21.
 */
public class BuildUser2 {
    final static Integer allnum = 2;
    final static Integer threadnum = 50;

    public static void main(String[] args) throws InterruptedException, ClassNotFoundException, SQLException {

        long start = System.currentTimeMillis();
//        String driver = "com.mysql.jdbc.Driver";
//        String url = "jdbc:mysql://localhost:3306/zootopia";
//        String user = "root";
//        String password = "souche2015";
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://am-bp15498n09ibndgxo131950o.ads.aliyuncs.com:3306/xin_test";
        String user = "xintest";
        String password = "Yitu2020";
        ExecutorService executor = Executors.newFixedThreadPool(threadnum);
        CountDownLatch count = new CountDownLatch(allnum);
        Semaphore semaphore = new Semaphore(threadnum);
        String sql = "insert INTO user (user_id,user_name,user_phone,password) VALUES (%s,%s,%s,%s);";
        String values = ",VALUES (%s,%s,%s,%s)";
        Class.forName(driver);
        Connection con = DriverManager.getConnection(url, user, password);
        con.setAutoCommit(false);
        PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);
        //遍历查询结果集
        try {
            //加载驱动程序
            for (int i = 0; i < allnum; i++) {
                semaphore.acquire();
                executor.execute(() -> {
                    try {
                        for (int j = 0; j < 50; j++) {
//                            pstmt.setString(1, RandomUtils.getID32());
//                            pstmt.setString(2, RandomUtils.getName());
//                            pstmt.setString(3, RandomUtils.getTel());
//                            pstmt.setString(4, RandomUtils.convertID(UUID.randomUUID().toString()));
                            System.out.println(String.format(sql, RandomUtils.getID32(), RandomUtils.getName(), RandomUtils.getTel(), RandomUtils.convertID(UUID.randomUUID().toString())));
                            pstmt.addBatch(String.format(sql, RandomUtils.getID32(), RandomUtils.getName(), RandomUtils.getTel(), RandomUtils.convertID(UUID.randomUUID().toString())));
                        }
                        pstmt.executeBatch();
                        con.commit();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } finally {
                        semaphore.release();
                        count.countDown();
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("数据库数据成功获取！！");
        }
        count.await();
        System.out.println("end ---------- HU " + (System.currentTimeMillis() - start) / 1000);
        pstmt.close();
        con.close();
        executor.shutdown();
    }
}
