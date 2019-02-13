package com.helloxin.util.function;

import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.ObjIntConsumer;

/**
 * Created by nandiexin on 2018/12/6.
 */
public class ConsumerLeaner {

    public static void testConsumer(){

        List<String> list = Arrays.asList("hello","xin","you","are","cool");

        list.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        System.out.println("-------------------------");
        list.forEach(s-> System.out.println(s));

        System.out.println("-------------------------");
        list.forEach(System.out::println);

    }

    public static void  testIntConsumer(){

        IntConsumer ic = (x)->System.out.println(x);

        ic.accept(3);

    }

    public static void  testObjIntConsumer(){

        ObjIntConsumer ic = (x,y)->{
            System.out.println(x);
            System.out.println(y);
        };

        ic.accept(3,7);

    }

    public static void  testConsumerAndThen(){

        Consumer<Integer> consumer= x-> System.out.print(" "+x);
        Consumer<Integer> consumerWithAndThen = consumer.andThen( i-> {
            System.out.print("(print "+i+")");
            System.out.println();}
        );
        List<Integer> integerList=Arrays.asList(1,2,3,4,5);
        for (Integer integer : integerList) {
            consumerWithAndThen.accept(integer);
        }
    }


    public static void main(String[] args) {


        testConsumerAndThen();

    }

}
