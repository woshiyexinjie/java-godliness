package com.helloxin.lang;

public class Main {
    public static void main(String[] args) {
//        Main m = (Main) null;
//        System.out.println(m);
//        m.doSomething();
        Main m = (Main) null;
        System.out.println(m instanceof Main);    //返回false哦 返回false哦 返回false哦
        System.out.println(m.getClass());
    }

    private static void doSomething() {
        System.out.println("doSomething");
    }

//    private  void doSomething() {
//        System.out.println("doSomething");
//    }
}
