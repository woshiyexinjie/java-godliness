package com.helloxin.temp;

import java.util.Objects;

public class Main {

    // Run this code in JDK 8

    public static void main(String[] args)
            throws NoSuchFieldException, IllegalAccessException {
//        System.out.println(MessageFormat.format("病灶uuid={0}关联的linkUuid={1}不属于同一个study", "123", "345"));

        String a = null;
        String b = "Hello world!";
        System.out.println(b.equals(a));
        System.out.println(Objects.equals(a, b));
    }
}
