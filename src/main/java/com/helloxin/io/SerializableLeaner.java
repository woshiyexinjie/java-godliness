package com.helloxin.io;

import java.io.*;

/**
 * Created by nandiexin on 2018/1/25.
 */
public class SerializableLeaner {
    //Serializable 将对象转换成二进制

    //这边先写来个那个例子

    public static void write() throws IOException {
        // 创建序列化流对象
        // public ObjectOutputStream(OutputStream out)
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("a.txt"));
        // 创建对象
        Person p = new Person("java", 20);
        p.setJob("programmer");
        oos.writeObject(p);
        // 释放资源
        oos.close();
    }

    public static void read() throws IOException {
        // 创建反序列化流对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                "a.txt"));
        // 读取,还原对象
        try {
            Person p = (Person) ois.readObject();
            System.out.println(p.toString());
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void writeExt() throws IOException {
        // 创建序列化流对象
        // public ObjectOutputStream(OutputStream out)
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("a.txt"));
        // 创建对象
        Person2 p = new Person2("java", 20);
        p.setJob("programmer");
        oos.writeObject(p);
        // 释放资源
        oos.close();
    }

    public static void readExt() throws IOException {
        // 创建反序列化流对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                "a.txt"));
        // 读取,还原对象
        try {
            Person2 p = (Person2) ois.readObject();
            System.out.println(p.toString());
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws IOException {
        write();
        read();
//
//        writeExt();
//        readExt();
    }


}
