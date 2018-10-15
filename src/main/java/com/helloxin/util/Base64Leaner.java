package com.helloxin.util;

import java.util.Base64;

/**
 * Created by nandiexin on 2018/2/8.
 */
public class Base64Leaner {


    public void base64Test(){

        String msg = "Hello xin, Base64!";
        Base64.Encoder enc = Base64.getEncoder();
        byte[] encbytes = enc.encode(msg.getBytes());
        for (int i = 0; i < encbytes.length; i++)
        {
            System.out.printf("%c", (char) encbytes[i]);
            if (i != 0 && i % 4 == 0) {
                System.out.print(' ');
            }
        }
        System.out.println();
        Base64.Decoder dec = Base64.getDecoder();
        byte[] decbytes = dec.decode(encbytes);
        System.out.println(new String(decbytes));

    }



    public static void main(String[] args)
    {
//        Base64Leaner base64Leaner = new Base64Leaner();
//        base64Leaner.base64Test();
        System.out.println("we".equals(null));
    }
}
