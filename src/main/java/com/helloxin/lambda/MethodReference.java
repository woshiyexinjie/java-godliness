package com.helloxin.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by nandiexin on 2018/11/6.
 */
public class MethodReference {

    public static void main(String[] args) {

        //使用labdas表达式
//        Stream.of(3,5,3,2,6,5,7,3,22,12).forEach(x->System.out.print(x));
//
//        System.out.println("---------------------------------");
//
//        //使用方法引用
//        Stream.of(3,5,3,2,6,5,7,3,22,12)
//                .forEach(System.out::print);
//        System.out.println("---------------------------------");
//
//        //将方法引用赋值给函数式接口
//        Consumer<Integer> printer = System.out::print;
//        Stream.of(3,5,3,2,6,5,7,3,22,12)
//                .forEach(printer);
//
//        System.out.println("---------------------------------");
//
//
//        Stream.generate(Math::random)
//                .limit(10)
//                .forEach(System.out::print);
//
//        System.out.println("---------------------------------");

        List<String> strings = Arrays.asList("This", "is", "a", "list", "of", "strings");

        List<String> sorted = strings.stream()
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList())
                ;
        System.out.println(sorted);

        System.out.println();
        strings.stream()
                .sorted(String::compareTo)
                .collect(Collectors.toList())
                .forEach(System.out::print);
//
//        System.out.println("---------------------------------");
//
//        Stream.of("This", "is", "a", "list", "of", "strings")
//                .map(String::length)
//                .forEach(System.out::print);
//
//        System.out.println("---------------------------------");
//
//        System.out.println("a".compareTo("b"));


    }

}
