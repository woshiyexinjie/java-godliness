package com.helloxin.lambda;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by nandiexin on 2019/1/8.
 */
public class StreamCreate {

    public static void main(String[] args) {


        //使用Stream of 创建流
        Stream.of(1,2,3,43,5,65).forEach(x-> System.out.println(x));

        Stream.of(1).forEach(x-> System.out.println(x));

        //使用Arrays.stream
        int num[] = {1,2,3,4,5,65,76};
        Arrays.stream(num).forEach(x-> System.out.println(x));

        //使用Stream.iterate
        Stream.iterate(1,x->x+1).limit(10).forEach(x-> System.out.println(x));

        //使用Stream.generate
        Stream.generate(Math::random).limit(10).forEach(x-> System.out.println(x));

        //从集合创建
        List<String> list = Arrays.asList("12","er","rt","22");
        list.stream().forEach(x-> System.out.println(x));

        //使用IntStream等的 range和rangeClose
        IntStream.range(5,10).forEach(x-> System.out.println(x));
        IntStream.rangeClosed(5,10).forEach(x-> System.out.println(x));





    }

}
