package com.helloxin.annotation;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by nandiexin on 2019/2/22.
 */
public class AnnotationTest {

    public static void main(String[] args) throws Exception {
        User user = UserFactory.create();

        System.out.println(user.getName());
        System.out.println(user.getAge());

        System.out.println(UserCheck.check(user));
    }
}
