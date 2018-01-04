package com.helloxin.net;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * create by nandiexin on 2018/1/4
 **/
public class InetAddressLeaner {


    public static void toucheMethod() throws IOException {
        /*
        通过主机名获取对应的ip地址：（当然也支持通过IP地址来查找主机名）
        该方法会建立与本地DNS的一个连接，来获取名称和地址之间的映射关系。（如果本地DNS缓存了地址，就不再获取连接。)

        由于DNS查找的开销很大，并且如果一个地址不可达，可能会需要几秒钟的时间来确认。
        InetAddress提供了缓存机制，一旦得到一个给定主机的地址，就会缓存起来，
        即使重新定义一个InetAddress类，也不会重新再获取一次，而是直接从缓存中获取。

        没有对应的setHostName()   代表着无法通过反射来改变其内部的

         1. 用 getLocalHost() 方法创建的InetAddress的对象  本机
         2. 用域名创建 InetAddress对象
            用域名作为getByName和getAllByName方法的参数得到的InetAddress对象，该对象会得到这个域名，当调用
            getHostName时，就无需再访问DNS服务器，而是直接将这个域名返回。
         3. 用IP地址 创建InetAddress对象
            使用IP地址创建InetAddress对象(getByName，getAllByName，getByAddress方法都可以通过IP地址创建InetAddress对象)时，
            并不需要访问DNS服务器。因此，通过DNS服务器查找域名的工作就由getHostName方法来完成。
            如果IP地址不存在或DNS服务器不允许进行IP地址和域名映射，就返回这个IP地址。
            getHostName时，就无需再访问DNS服务器，而是直接将这个域名返回。

        不成功的主机名解析结果缓存的一个很短的时间（10秒）以提高性能
        networkaddress.cache.ttl
        Indicates the caching policy for successful name lookups from the name service.
        The value is specified as as integer to indicate the number of seconds to cache the successful lookup.
        The default setting is to cache for an implementation specific period of time.
        A value of -1 indicates "cache forever".

        networkaddress.cache.negative.ttl (default: 10)
        Indicates the caching policy for un-successful name lookups from the name service.
        The value is specified as as integer to indicate the number of seconds
        to cache the failure for un-successful lookups.
        A value of 0 indicates "never cache". A value of -1 indicates "cache forever".
         */
        InetAddress addr = InetAddress.getByName("www.baidu.com");

        System.out.println( addr.getHostName());  //获得主机名
        System.out.println( addr.getHostAddress());   //获得IP地址
        /*
        得到真正的主机名和IP地址。
         */
//        System.out.println( InetAddress.getLocalHost().getHostName());


        System.out.println( addr.getAddress());
        // 该方法和getHostName方法一样，也是得到远程主机的域名。区别是，该方法得到的是主机名，getHostName得到的是主机别名
        System.out.println( addr.getCanonicalHostName());
        System.out.println( addr.isAnyLocalAddress());
        System.out.println( addr.isLinkLocalAddress());
        System.out.println( addr.isLoopbackAddress());
        System.out.println( addr.isMCGlobal());
        System.out.println( addr.isMCLinkLocal());
        System.out.println( addr.isMCNodeLocal());
        System.out.println( addr.isMCOrgLocal());
        System.out.println( addr.isMCSiteLocal());
        System.out.println( addr.isMulticastAddress());
        System.out.println( addr.isReachable(100));

    }



    public static void main(String[] args) throws IOException {

        toucheMethod();
    }
}
