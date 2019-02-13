package com.helloxin.util.function;

import java.util.Random;
import java.util.function.DoubleSupplier;
import java.util.function.IntSupplier;

/**
 * Created by nandiexin on 2018/12/10.
 */
public class SupplierLeaner {


    public static void testSupplier(){

        DoubleSupplier doubleSupplier = new DoubleSupplier() {
            @Override
            public double getAsDouble() {
                return Math.random()*100;
            }
        };
        System.out.println(doubleSupplier.getAsDouble());

        doubleSupplier = ()->(int) (Math.random()*10);
        System.out.println(doubleSupplier.getAsDouble());

        doubleSupplier = Math::random;
        System.out.println(doubleSupplier.getAsDouble());

    }


    public static void main(String[] args) {

        testSupplier();

    }



}
