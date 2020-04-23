package com.helloxin.count;


import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import net.agkn.hll.HLL;

import java.util.stream.LongStream;

/**
 * Created by yebanxian on 2020/4/23.
 */
public class HyperLogLogTest {
    public static void main(String[] args) {
        HashFunction hashFunction = Hashing.murmur3_128();
        long numberOfElements = 100_000_000;
        HLL hll = new HLL(14, 5);
        LongStream.range(0, numberOfElements).forEach(element -> {
                    long hashedValue = hashFunction.newHasher().putLong(element).hash().asLong();
                    hll.addRaw(hashedValue);
                }
        );
        long cardinality = hll.cardinality();
        System.out.println(cardinality);
    }
}
