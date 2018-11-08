package com.helloxin.jdk9;

/**
 * Created by nandiexin on 2018/11/8.
 */
public interface TestInterface2 extends  TestInterface{


    //abstract method
    @Override
    public void square(int a);

    //default method
    @Override
    default void show()

    {

        System.out.println("TestInterface2 Default Method Executed");

    }

}
