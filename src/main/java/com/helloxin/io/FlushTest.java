package com.helloxin.io;

import java.io.*;

public class FlushTest {
    public static void main(String[] args) throws IOException {
//        FileInputStream fis = new FileInputStream("./aa.txt");
//        FileOutputStream fos = new FileOutputStream("bb.txt");
//        //创建缓冲区，对输入流进行包装
//        BufferedInputStream bis = new BufferedInputStream(fis);
//        //创建缓冲区，对输出流进行包装
//        BufferedOutputStream bos = new BufferedOutputStream(fos);
//
//        int b;
//        while ((b = bis.read()) != -1) {
//            bos.write(b);
//        }
//        //清理缓冲区
//        bos.flush();
//        //关闭之前也会清理缓冲区
//        bos.close();

        System.out.println(System.getProperty("file.encoding"));
    }
}
