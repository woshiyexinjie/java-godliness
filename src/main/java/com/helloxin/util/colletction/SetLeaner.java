package com.helloxin.util.colletction;

import java.util.LinkedHashSet;

/**
 * Created by nandiexin on 2019/2/13.
 */
public class SetLeaner {

    public static void linkedHashSetLeaner(){

    }


    public static void main(String[] args) {

        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();



         // 创建并添加元素

        linkedHashSet.add("hello");

        linkedHashSet.add("world");

        linkedHashSet.add("java");

        linkedHashSet.add("java");

        linkedHashSet.add("hello");

        linkedHashSet.add("world");

        linkedHashSet.add("java");

        // 便利结合

        for (String s : linkedHashSet) {

            System.out.println(s);

        }


    }

}
