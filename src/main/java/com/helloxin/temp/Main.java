package com.helloxin.temp;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws UnknownHostException, IOException {

        String address = ",,,1";
        System.out.println(Arrays.toString(address.split(",")));
        System.out.println(Arrays.toString(address.split(",", -1)));
        System.out.println(Arrays.toString(address.split(",", 0)));

    }

}
