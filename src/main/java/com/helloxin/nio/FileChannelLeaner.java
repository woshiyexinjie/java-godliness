package com.helloxin.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by nandiexin on 2019/2/18.
 */
public class FileChannelLeaner {

    public static void main(String[] args) throws IOException {

        RandomAccessFile aFile = new RandomAccessFile("/Users/yexinjie/Documents/jdk_source/jdk8/java/io/PipedReader.java", "rw");
        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(48);

        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {

            System.out.println("Read " + bytesRead);
            buf.flip();

            while(buf.hasRemaining()){
                System.out.print((char) buf.get());
            }

            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        aFile.close();


//        RandomAccessFile fromFile = new RandomAccessFile("/Users/yexinjie/Documents/jdk_source/jdk8/java/io/PipedReader.java", "rw");
//        FileChannel      fromChannel = fromFile.getChannel();
//
//        RandomAccessFile toFile = new RandomAccessFile("/Users/yexinjie/Documents/ta.txt", "rw");
//        FileChannel      toChannel = toFile.getChannel();
//
//        long position = 0;
//        long count    = fromChannel.size();
//
//        toChannel.transferFrom(fromChannel, position, count);



    }

}
