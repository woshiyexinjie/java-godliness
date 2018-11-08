package com.helloxin.jdk9;

/**
 * Created by nandiexin on 2018/11/8.
 */
public class TestClass implements TestInterface4

{

    //implementation of square abstract method

    @Override
    public void square(int a)

    {

        System.out.println(a*a);

    }

    public static void main(String args[]){

        //这里是测试default方法的多继承问题
        TestInterface d = new TestClass();

        d.square(4);

        //default method executed

        d.show();

    }

}