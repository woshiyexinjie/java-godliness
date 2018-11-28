package com.helloxin.lang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Created by nandiexin on 2018/11/20.
 */
public class StringReverseDemo {


    public static void main(String[] args) {

    }


    public String reverseWithStringConcat(String input) {
        String output = new String();
        for (int i = (input.length() - 1); i >= 0; i--) {
            output += (input.charAt(i));
        }
        display(input, output);
        return output;
    }

    public String reverseWithStringBuilderBuiltinMethod(String string) {
        final StringBuilder builder = new StringBuilder(string);
        display(string, builder.reverse().toString());
        return builder.reverse().toString();
    }


    public String reverseWithStringChatAt(String string) {
        final StringBuilder builder = new StringBuilder();
        for (int i = (string.length() - 1); i >= 0; i--) {
            builder.append(string.charAt(i));
        }
        display(string, builder.toString());
        return builder.toString();
    }

    public String reverseWithSwaps(String string) {
        final char[] array = string.toCharArray();
        final int length = array.length - 1;
        final int half = (int) Math.floor(array.length / 2);
        char c;
        for (int i = length; i >= half; i--) {
            c = array[length - i];
            array[length - i] = array[i];
            array[i] = c;
        }
        display(string, String.valueOf(array));
        return String.valueOf(array);
    }

    public String reverseWithXOR(String string) {
        final char[] array = string.toCharArray();
        final int length = array.length;
        final int half = (int) Math.floor(array.length / 2);
        for (int i = 0; i < half; i++) {
            array[i] ^= array[length - i - 1];
            array[length - i - 1] ^= array[i];
            array[i] ^= array[length - i - 1];
        }
        display(string, String.valueOf(array));
        return String.valueOf(array);
    }

    public static String reverse(String str) {
        // base case: if string is null or empty
        if (str == null || str.equals("")) {
            return str;
        }
        // create an empty stack of characters
        Stack< Character > stack = new Stack < Character > ();
        // push every character of the given string into the stack
        char[] ch = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            stack.push(ch[i]);
        }
        // start from index 0
        int k = 0;
        // pop characters from the stack until it is empty
        while (!stack.isEmpty()) {
            // assign each popped character back to the character array
            ch[k++] = stack.pop();
        }
        // convert the character array into string and return it
        return String.copyValueOf(ch);
    }

    public static String reverse2(String str) {
        // base case: if string is null or empty
        if (str == null || str.equals("")) {
            return str;
        }
        // create an empty list of characters
        List< Character > list = new ArrayList< Character >();
        // push every character of the given string into it
        for (char c: str.toCharArray()) {
            list.add(c);
        }
        // reverse list using java.util.Collections reverse()
        Collections.reverse(list);
        // covert ArrayList into String using StringBuilder and return it
        StringBuilder builder = new StringBuilder(list.size());
        for (Character c: list) {
            builder.append(c);
        }
        return builder.toString();
    }

    // Function to reverse a string in Java using byte array
    public static String reverse3(String str) {
        // return if string is null or empty
        if (str == null || str.equals("")) {
            return str;
        }
        // convert string into bytes
        byte[] bytes = str.getBytes();
        // start from the two end points l and h of the given string
        // and increment l & decrement h at each iteration of the loop
        // until two end-points intersect (l >= h)
        for (int l = 0, h = str.length() - 1; l < h; l++, h--) {
            // Swap values at l and h
            byte temp = bytes[l];
            bytes[l] = bytes[h];
            bytes[h] = temp;
        }
        // convert byte array back into the string
        return new String(bytes);
    }

//    private static String reverse(String str) {
//        // base case: if string is null or empty
//        if (str == null || str.equals("")) {
//            return str;
//        }
//        // last character + recurse for remaining string
//        return str.charAt(str.length() - 1) + reverse(str.substring(0, str.length() - 1));
//    }


//    // Recursive function to reverse a string in Java using static variable
//    private static void reverse(char[] str, int k) {
//        // if we have reached the end of the string
//        if (k == str.length) {
//            return;
//        }
//        // recurse for next character
//        reverse(str, k + 1);
//        if (i <= k) {
//            char temp = str[k];
//            str[k] = str[i];
//            str[i++] = temp;
//        }
//    }
//    public static String reverse(String str) {
//        // base case: if string is null or empty
//        if (str == null || str.equals(""))
//            return str;
//        // convert string into a character array
//        char[] A = str.toCharArray();
//        // reverse character array
//        reverse(A, 0);
//        // convert character array into the string
//        return String.copyValueOf(A);
//    }



    private void display(String input, String output) {
        System.out.println(" input string :: " + input);
        System.out.println(" output string :: " + output);
    }
}
