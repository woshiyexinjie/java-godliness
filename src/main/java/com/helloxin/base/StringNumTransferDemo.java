package com.helloxin.base;

public class StringNumTransferDemo {
    public static void main(String[] args) {

//        int resultSigned = Integer.compare(Integer.MIN_VALUE, Integer.MAX_VALUE);
//        int resultUnsigned = Integer.compareUnsigned(Integer.MIN_VALUE, Integer.MAX_VALUE);
//
//        System.out.println("Signed ints: " + Integer.MIN_VALUE + ", " + Integer.MAX_VALUE);
//        System.out.println("-----------------------------------------------");
//        System.out.println("Result of comparing signed: " + resultSigned);
//        System.out.println("Result of comparing unsigned: " + resultUnsigned);
//
//        long result = Integer.toUnsignedLong(Integer.MIN_VALUE);
//
//        System.out.println("Integer.MIN_VALUE: " + Integer.MIN_VALUE);
//        System.out.println("Result: " + result);
//
//        System.out.println();
//
//        int result1 = Short.toUnsignedInt(Short.MIN_VALUE);
//        int result2 = Short.toUnsignedInt(Short.MAX_VALUE);
//
//        System.out.println("Short.MIN_VALUE: " + Short.MIN_VALUE + " Short.MAX_VALUE: " + Short.MAX_VALUE);
//        System.out.println("Result 1: " + result1);
//        System.out.println("Result 2: " + result2);

        System.out.println("Division:\n--------------");
        int divisionSignedMinMax = Integer.MIN_VALUE / Integer.MAX_VALUE;
        int divisionSignedMaxMin = Integer.MAX_VALUE / Integer.MIN_VALUE;

        System.out.println("Division signed MIN/MAX: " + divisionSignedMinMax);
        System.out.println("Division signed MAX/MIN: " + divisionSignedMaxMin);

        // unsigned division
        int divisionUnsignedMinMax = Integer.divideUnsigned(Integer.MIN_VALUE, Integer.MAX_VALUE);
        int divisionUnsignedMaxMin = Integer.divideUnsigned(Integer.MAX_VALUE, Integer.MIN_VALUE);

        System.out.println("Division unsigned MIN/MAX: " + divisionUnsignedMinMax);
        System.out.println("Division unsigned MAX/MIN: " + divisionUnsignedMaxMin);

        // signed modulo
        System.out.println("\nModulo:\n--------------");
        int moduloSignedMinMax = Integer.MIN_VALUE % Integer.MAX_VALUE;
        int moduloSignedMaxMin = Integer.MAX_VALUE % Integer.MIN_VALUE;

        System.out.println("Modulo signed MIN/MAX: " + moduloSignedMinMax);
        System.out.println("Modulo signed MAX/MIN: " + moduloSignedMaxMin);

        // unsigned modulo
        int moduloUnsignedMinMax = Integer.remainderUnsigned(Integer.MIN_VALUE, Integer.MAX_VALUE);
        int moduloUnsignedMaxMin = Integer.remainderUnsigned(Integer.MAX_VALUE, Integer.MIN_VALUE);

        System.out.println("Modulo unsigned MIN/MAX: " + moduloUnsignedMinMax);
        System.out.println("Modulo unsigned MAX/MIN: " + moduloUnsignedMaxMin);
    }
}
