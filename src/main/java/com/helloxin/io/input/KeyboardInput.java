package com.helloxin.io.input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by yebanxian on 2020/3/29.
 */
public class KeyboardInput {
    public static void main(String[] args) throws IOException {
//        Scanner input = new Scanner(System.in);
//        String s = input.nextLine();
//        System.out.println(s);
//        input.close();

        BufferedReader input2 = new BufferedReader(new InputStreamReader(System.in));
        String s2 = input2.readLine();
        System.out.println(s2);
        input2.close();
    }
}
