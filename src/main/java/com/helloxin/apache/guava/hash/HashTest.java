package com.helloxin.apache.guava.hash;

import com.google.common.base.Charsets;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import com.google.common.math.IntMath;

/**
 * Created by yebanxian on 2020/4/22.
 */
public class HashTest {
    public static void main(String[] args) {
        HashFunction hf = Hashing.md5();
        HashCode hc = hf.newHasher()
                .putLong(1)
                .putString("123", Charsets.UTF_8)
                .hash();
        System.out.println(hc.asLong());

        int i = IntMath.checkedMultiply(100003453, 10000000);
        System.out.println(i);
    }
}
