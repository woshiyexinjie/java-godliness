package com.helloxin.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nandiexin on 2018/11/28.
 */
public class RemoveIfDemo {

    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(-3); nums.add(1); nums.add(4);
        nums.add(-1); nums.add(2); nums.add(8);
        nums.forEach(x-> System.out.println(x));

//        boolean removeIf = nums.removeIf(n -> n >= 0);
        boolean removeIf = nums.removeIf(n->{
                if(n>0){
                    return true;
                }
                return false;
        });
        System.out.println(nums);


    }
}
