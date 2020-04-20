package com.helloxin.search;


import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * Created by yebanxian on 2020/4/20.
 */
public class BloomFilterTest {
    public static void main(String[] args) {
        BloomFilter filter = BloomFilter.create(
                Funnels.integerFunnel(),
                500,
                0.01);
        filter.put(1);
        filter.put(2);
        filter.put(3);

        System.out.println(filter.mightContain(1));
    }
}
