package com.helloxin.lang;

/**
 * create by nandiexin on 2017/12/22
 **/
public class CharLeaner {

    //因为以前用 c 或者 c++ 记得ascii码与字符的互转 可以很方便 但是java有点不顺手啦

    //除了这样强转的方式 还有其他更好的方式吗

    /**
     * 这种方式 用的不是很爽
     * @param num
     * @return
     */
     public static  char asciiToChar(int num){

         return  (char)num;
     }

    /**
     * 字符转ascii
     * @param ch
     * @return
     */
     public static  int charToAscii(char ch){

        return  (int)ch;
     }



    public static void main(String[] args) {
        System.out.println(asciiToChar(98));
        System.out.println(charToAscii('B'));
    }


}
