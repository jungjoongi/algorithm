package com.jungjoongi.algorithm.programmers;

import java.util.*;

public class Main5 {

    public static void main(String[] args) {

        int[] arr = {1,2,3,2};
        Map<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        boolean isChange = false;
        for(int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) != null) {
                int tempInt = (i - map.get(arr[i]));
                if (tempInt < min) {
                    min = tempInt;
                    isChange = true;
                }
            }
            map.put(arr[i], i);
        }
        if(isChange) {
            System.out.println(min);
        } else {
            System.out.println(-1);
        }


    }
}
