package com.helloxin.jdk9;

/**
 * Created by nandiexin on 2018/11/8.
 */
public interface TestInterface4 extends  TestInterface2,TestInterface3{

    @Override
    default void square(int a) {

    }

    @Override
    default void show() {
        System.out.println(
                "TestInterface2 Default Method Executed"
        );
    }
}
