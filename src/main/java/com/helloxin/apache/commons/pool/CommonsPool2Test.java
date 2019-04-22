package com.helloxin.apache.commons.pool;

import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/**
 * Created by nandiexin on 2019/4/17.
 */
public class CommonsPool2Test {

    public static void main(String[] args) throws Exception {

        ObjectPool op = new GenericObjectPool<StringBuffer>(new MyPooledObjectFactoryExample(), new GenericObjectPoolConfig());

        //从ObjectPool租借对象StringBuffer
        StringBuffer sb = (StringBuffer) op.borrowObject();
        sb.append("aaa");
        System.out.println(sb.toString());
        //归还对象StringBuffer
        op.returnObject(sb);

        StringBuffer sb2 = (StringBuffer) op.borrowObject();
        System.out.println(sb2.toString());

        System.out.println("isEquals：" + (sb == sb2));
        op.returnObject(sb2);

        for (int i = 0; i < 8; i++) {
            StringBuffer temp = (StringBuffer) op.borrowObject();
            System.out.println(temp.toString());
        }


        System.out.println("FINISH");
    }

}
