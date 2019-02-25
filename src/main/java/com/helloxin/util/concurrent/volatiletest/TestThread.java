package com.helloxin.util.concurrent.volatiletest;

/**
 * Created by nandiexin on 2019/2/21.
 */
public class TestThread {

    public static void main(String[] args) {

        //这里如果不使用 volatile 那么threadB都会从主内存中读取数据 运行不会报错
        MyList list = new MyList();
        ThreadA a = new ThreadA(list);
        a.setName("a");
        a.start();
        ThreadB b = new ThreadB(list);
        b.setName("b");
        b.start();
    }
}
