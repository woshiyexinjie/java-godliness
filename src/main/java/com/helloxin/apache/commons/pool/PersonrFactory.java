package com.helloxin.apache.commons.pool;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

public class PersonrFactory extends BasePooledObjectFactory<Person> {
    // 创建一个新的对象
    @Override
    public Person create() {
        return new Person();
    }

    // 封装为池化对象
    @Override
    public PooledObject<Person> wrap(Person person) {
        return new DefaultPooledObject<>(person);
    }

    // 使用完返还对象时将 StringBuffer 清空
    @Override
    public void passivateObject(PooledObject<Person> pooledObject) {
        pooledObject.getObject().setName("");
    }
}