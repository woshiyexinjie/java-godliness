package com.helloxin.apache.commons.pool;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

public class StringBufferFactory extends BasePooledObjectFactory<StringBuffer> {
    // 创建一个新的对象
    @Override
    public StringBuffer create() {
        return new StringBuffer();
    }

    // 封装为池化对象
    @Override
    public PooledObject<StringBuffer> wrap(StringBuffer buffer) {
        return new DefaultPooledObject<>(buffer);
    }

    // 使用完返还对象时将 StringBuffer 清空
    @Override
    public void passivateObject(PooledObject<StringBuffer> pooledObject) {
        pooledObject.getObject().setLength(0);
    }
}