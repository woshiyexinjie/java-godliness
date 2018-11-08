package com.helloxin.lambda;

import java.util.Date;
import java.util.Objects;

/**
 * Created by nandiexin on 2018/11/7.
 */
@FunctionalInterface
public interface MyInterface {

    abstract  public void  getMyname();

//    abstract  public void  getMyname2();

    default Date getDate(){
        return new Date();
    }

    static void printHello(){
        System.out.println("hello girl!");
    }

    //接口可能也是继承了Object父类 所以这些算是重写吗

    @Override
    boolean equals(Object object);

}
