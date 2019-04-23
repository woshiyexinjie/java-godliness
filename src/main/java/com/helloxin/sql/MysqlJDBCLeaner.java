package com.helloxin.sql;

import com.helloxin.reflection.sql.ResultSetPropertiesHelper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by nandiexin on 2019/4/22.
 */
public class MysqlJDBCLeaner {

    public static void main(String[] args) {
        Connection con;
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/zootopia";
        String user = "root";
        String password = "XXXXXXXXX";
        //遍历查询结果集
        try {
            //加载驱动程序
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);

            Statement statement = con.createStatement();
            String sql = "select * from user";
            ResultSet rs = statement.executeQuery(sql);

//            String name = null;
//            String phone = null;
//            while(rs.next()){
//                //获取stuname这列数据
//                name = rs.getString("user_name");
//                //获取stuid这列数据
//                phone = rs.getString("user_phone");
//                //输出结果
//                System.out.println(name + "\t" + phone);
//            }

            ArrayList<UserDO> userDOS = ResultSetPropertiesHelper.transferResult(rs, UserDO.class);
            for (UserDO userDO : userDOS) {
                System.out.println(userDO.toString());
            }
            rs.close();
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
