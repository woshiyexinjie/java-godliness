package com.helloxin.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by nandiexin on 2019/2/19.
 */
public class SocketChannelLeaner {


    public static void main(String[] args) throws IOException {

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("127.0.0.1", 80));


        ByteBuffer buf = ByteBuffer.allocate(48);

        int bytesRead = socketChannel.read(buf);
        System.out.println(bytesRead);

        //这里还是要关掉的吧
        socketChannel.close();

        //写一行文字

        //写第二行文字

    }
}
