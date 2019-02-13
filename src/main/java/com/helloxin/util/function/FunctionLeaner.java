package com.helloxin.util.function;

import java.util.List;
import java.util.SortedMap;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by nandiexin on 2018/12/13.
 */
public class FunctionLeaner {


    public static void testFunction() {


        List<String> list = List.of("hello", "world");
        List<Integer> length = list.stream()
                .map(new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) {
                        return s.length();
                    }
                }).collect(Collectors.toList());

        System.out.println("匿名内部类 length=" + length);

        length = list.stream().map(s -> s.length()).collect(Collectors.toList());

        System.out.println("lambda length=" + length);

        length = list.stream().map(String::length).collect(Collectors.toList());

        System.out.println("方法引用 length=" + length);



        Function<Integer, Integer> times2 = e -> e +1;

        Function<Integer, Integer> squared = e -> e * e;

        System.out.println(times2.compose(squared).apply(4));

        System.out.println(times2.andThen(squared).apply(4));

    }


    public static void main(String[] args) {

        testFunction();

    }
}
