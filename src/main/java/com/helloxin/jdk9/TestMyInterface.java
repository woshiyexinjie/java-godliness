package com.helloxin.jdk9;

/**
 * Created by nandiexin on 2018/11/8.
 */
public class TestMyInterface {

    public static void main(String[] args) {

        TestInterface4 d = new TestClass();

        d.square(4);

        //default method executed

        d.show();
    }
}
