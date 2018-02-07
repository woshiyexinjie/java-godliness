package com.helloxin.jdk9;

import java.util.*;

import static java.util.Map.entry;

/**
 * Created by nandiexin on 2018/2/6.
 */
public class ImmutableCollections {
    //如何用 java 9中提供的集合静态方法 创建不可变集合


    public void previousVersion(){
        Map<String, Integer> map = new HashMap<>();

        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        System.out.println(map.hashCode());

        map = Collections.unmodifiableMap(map);

        System.out.println(map.hashCode());
    }

    public void previousVersionSimple(){
        Map<String, Integer> map = Collections.unmodifiableMap(
                new HashMap<String, Integer>() {{
                    put("one", 1);
                    put("two", 2);
                    put("three", 3);
                }});
        map.put("HelloQ",3);
    }

    public void factoryMethod(){
        List<String> animals = List.of("Cat", "Dog", "Lion", "Tiger");
//        animals.add("elephont");

        Set<String> socialMedia = Set.of("Facebook", "Twitter", "Linkedin",
                "Pinterest", "Google+");

        Map<String, Integer> numberMap = Map.of("one", 1, "two", 2, "three", 3);


        Map<String, Integer> numerMap = Map.ofEntries(
                entry("one", 1),
                entry("two", 2),
                entry("three", 3)
        );
    }

    public void nullValue(){

        List<String> list = List.of("A", "B", null, "C");

        Set<String> set = Set.of("Computer", "Mobile", null, "TV");

        Map<String, String> asciiMap = Map.of("A", "a", "B", null);


        Map<String, String> map = Map.ofEntries(
                entry("A", "a"),
                entry("B", null)
        );
    }

    public void duplicateValue(){
        //会报错
//        Set<String> set = Set.of("A", "B", "A");

//        Set<String> set2 = Collections.unmodifiableSet(
//                new HashSet<>(Arrays.asList("A","B","A"))
//        );

//        Map.of("A", 1, "A", 2);

        //这样是可以的
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("A", 2);
        map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {
        ImmutableCollections immutableCollections = new ImmutableCollections();
        immutableCollections.duplicateValue();

        List<String> list = new ArrayList<>();
        list.add(null);
        list.add(null);
        System.out.println(list.size());

        Set<String> set = new HashSet<>();
        set.add(null);
        set.add(null);
        System.out.println(set.size());

        Map<String,String> map = new HashMap();
        map.put(null,"");
        map.put(null,"");
        System.out.println(map.size());
        map.put("",null);
        map.put("",null);
        System.out.println(map.size());
        map.put(null,null);
        System.out.println(map.size());


    }
}
