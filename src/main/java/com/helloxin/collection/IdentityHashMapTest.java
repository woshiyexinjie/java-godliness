package com.helloxin.collection;

import java.util.IdentityHashMap;
import java.util.Map;

/**
 * Created by yebanxian on 2020/9/7.
 */
public class IdentityHashMapTest {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        Map<String, String> identityHashMap = new IdentityHashMap<>();
        String one = new String("a");
        String two = new String("a");
        String three = new String("a");
        System.out.println(one == three);
        System.out.println(one == two);
        System.out.println(one == "a");
        identityHashMap.put(one, "1");
        identityHashMap.put(two, "2");
        identityHashMap.put(three, "3");
        System.out.println(identityHashMap.size());
        System.out.println(identityHashMap.get(one));

        Map<Demo, String> identityHashMap2 = new IdentityHashMap<>();
        identityHashMap2.put(new Demo(1), "1");
        identityHashMap2.put(new Demo(1), "2");
        identityHashMap2.put(new Demo(1), "3");
        System.out.println(identityHashMap2.size());
    }

    private static class Demo {
        private Integer id;

        public Demo(Integer id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object obj) {
            return true;
        }

        @Override
        public int hashCode() {
            return id;
        }
    }
}


