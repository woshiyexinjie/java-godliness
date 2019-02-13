package com.helloxin.util.function;

import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

/**
 * Created by nandiexin on 2018/12/18.
 */
public class UnaryOperatorLeaner {


    public static void main(String[] args) {


        List<String> list = List.of("hello", "world");
        List<String> strings = list.stream()
                .map(new UnaryOperator<String>() {

                    @Override
                    public String apply(String s) {
                        return s;
                    }
                }).collect(Collectors.toList());

        System.out.println("匿名内部类 strings=" + strings);

        strings = list.stream().map(s -> s.toString()).collect(Collectors.toList());

        System.out.println("lambda strings=" + strings);

        strings = list.stream().map(String::toString).collect(Collectors.toList());

        System.out.println("方法引用 strings=" + strings);

    }


}
