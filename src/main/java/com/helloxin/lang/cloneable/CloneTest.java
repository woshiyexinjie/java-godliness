package com.helloxin.lang.cloneable;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.*;

/**
 * Created by nandiexin on 2019/3/19.
 */
public class CloneTest {


    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {

//        Address a=new Address();
//        a.setRoom("1002");
//        a.setSteet("north road");
//
//
//        People p1=new People(a,"helloxin",19);
//        People p2=(People)p1.clone();
//
//
//        System.out.println("p1是"+p1);
//        System.out.println("p2是"+p2);
//
//        p1.setName("小傻瓜");
//        a.setRoom("1003");
//        System.out.println("修改后的p1是"+p1);
//        System.out.println("修改后的p2是"+p2);

        //使用序列化的方式 当然序列化的实现又恨

//        Address a=new Address();
//        a.setRoom("1002");
//        a.setSteet("north road");
//
//
//        People p1=new People(a,"helloxin",19);
//        ByteArrayOutputStream bos=new ByteArrayOutputStream();
//        ObjectOutputStream oos=new ObjectOutputStream(bos);
//        oos.writeObject(p1);
//        oos.flush();
//
//        ObjectInputStream ois=new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
//        People p2=(People)ois.readObject();
//
//        System.out.println("p1是"+p1);
//        System.out.println("p2是"+p2);
//
//        p1.setName("小傻瓜");
//        a.setRoom("1003");
//        System.out.println("修改后的p1是"+p1);
//        System.out.println("修改后的p2是"+p2);

        Address a=new Address();
        a.setRoom("1002");
        a.setSteet("north road");


        People p1=new People(a,"helloxin",19);
        String json = JSON.toJSONString(p1);
        People p2 = JSON.parseObject(json,People.class);

        System.out.println("p1是"+p1);
        System.out.println("p2是"+p2);

        p1.setName("小傻瓜");
        a.setRoom("1003");
        System.out.println("修改后的p1是"+p1);
        System.out.println("修改后的p2是"+p2);

    }
}
