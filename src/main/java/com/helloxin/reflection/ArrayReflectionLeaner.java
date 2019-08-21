package com.helloxin.reflection;

/**
 * Created by nandiexin on 2019/4/23.
 */
public class ArrayReflectionLeaner {

    public static void main(String[] args) throws ClassNotFoundException {


        Class intArray = Class.forName("[I");
        System.out.println(intArray.isArray());

        String[] strings = new String[3];
        Class stringArrayClass = strings.getClass();
        Class stringArrayComponentType = stringArrayClass.getComponentType();
        System.out.println(stringArrayComponentType);

    }
}
