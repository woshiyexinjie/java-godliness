package com.helloxin.jdk9;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Created by nandiexin on 2018/2/3. 这里学习一下 java 9 中对Stream api 的增强
 */
public class StreamAPIEnhance {


    public void takeWhileTest(){
        List<Integer> numbers = List.of(2, 4, 6, 7, 8, 10);
        numbers.stream().takeWhile(n -> n%2 == 0).forEach(System.out::println);

        System.out.println("------------------------------");

        Set<Integer> numbers2 = Set.of(2, 4, 6, 7, 8, 10);
        numbers2.stream().takeWhile(n -> n%2 == 0).forEach(System.out::println);
    }

    public void dropWhileTest(){
        List<Integer> numbers = List.of(2, 4, 6, 7, 8, 10);
        numbers.stream().dropWhile(n -> n%2 == 0).forEach(System.out::println);

        System.out.println("------------------------------");

        Set<Integer> numbers2 = Set.of(2, 4, 6, 7, 8, 10);
        numbers2.stream().dropWhile(n -> n%2 == 0).forEach(System.out::println);
    }

    public void ofNullableTest(){

        Stream.ofNullable("Hello").forEach(System.out::println);
        Stream.ofNullable(null).forEach(System.out::println);

    }

    public void iterator(){

//        Stream.iterate(1, i -> i+1);
//        Stream.iterate(1, i -> i+1).limit(10).forEach(System.out::println);

        Stream.iterate(1, i -> i <= 10, i -> i+1).forEach(System.out::println);



    }
    public static void main(String[] args) {

        StreamAPIEnhance streamAPIEnhance = new StreamAPIEnhance();
        streamAPIEnhance.iterator();
    }
}
