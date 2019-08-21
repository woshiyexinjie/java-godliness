package com.helloxin.sql;

import com.helloxin.reflection.sql.ResultSetPropertiesHelper;
import com.helloxin.util.RandomUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by nandiexin on 2019/5/21.
 */
public class BuildSomeUsersUtils {


    public static void main(String[] args) {

        Connection con;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/zootopia";
        String user = "root";
        String password = "souche2015";
        //遍历查询结果集
        try {
            //加载驱动程序
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);

            String sql = "insert INTO user (user_id,user_name,user_phone,password) VALUES (?,?,?,?)";

            PreparedStatement pstmt = (PreparedStatement) con.prepareStatement(sql);

            for (int i = 0; i < 5000; i++) {
                pstmt.setString(1, RandomUtils.getID32());
                pstmt.setString(2, RandomUtils.getName());
                pstmt.setString(3, RandomUtils.getTel());
                pstmt.setString(4, RandomUtils.convertID(UUID.randomUUID().toString()));

                pstmt.executeUpdate();
            }

            pstmt.close();
            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("数据库数据成功获取！！");
        }


    }
}
