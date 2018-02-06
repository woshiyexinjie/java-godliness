package com.helloxin;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        String param = "18868843789";
        Integer len = param.length();
        System.out.println("len:"+len);
        String test =  param.replaceAll("(?<=[\\d]{3})\\d(?=[\\d]{5})", "*");
        System.out.println(test);
        System.out.println(test.length());
    }
}
