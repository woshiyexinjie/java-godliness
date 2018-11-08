package com.helloxin.jdk9;

/**
 * Created by nandiexin on 2018/11/8.
 */
public interface TestInterface {


    //abstract method

    public void square(int a);

    //default method

    default void show()

    {

        System.out.println("TestInterface Default Method Executed");

    }
}
