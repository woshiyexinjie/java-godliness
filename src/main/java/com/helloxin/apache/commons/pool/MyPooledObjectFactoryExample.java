package com.helloxin.apache.commons.pool;

import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;

/**
 * Created by nandiexin on 2019/4/17.
 */
public class MyPooledObjectFactoryExample implements PooledObjectFactory<StringBuffer> {

    @Override
    public PooledObject<StringBuffer> makeObject() throws Exception {
        return new DefaultPooledObject<StringBuffer>(new StringBuffer());
    }

    @Override
    public void destroyObject(PooledObject<StringBuffer> p) throws Exception {
        StringBuffer sb = p.getObject();
        sb = null;
    }

    @Override
    public boolean validateObject(PooledObject<StringBuffer> p) {
        return p.getObject() != null;
    }

    @Override
    public void activateObject(PooledObject<StringBuffer> p) throws Exception {
        if (null == p.getObject()) {
            p = new DefaultPooledObject<StringBuffer>(new StringBuffer());
        }
    }

    @Override
    public void passivateObject(PooledObject<StringBuffer> p) throws Exception {
        // TODO Auto-generated method stub

    }
}

