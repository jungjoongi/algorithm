package com.jungjoongi.algorithm.programmers.exercise;


import java.util.*;

public class Main24 {

    public static void main(String[] args) {

        solution(new int[]{3, 3, 3, 2, 2, 4});
    }

    public static int solution(int[] nums) {
        int size = nums.length / 2;
        int result = Arrays.stream(nums).distinct().toArray().length;
        return result >= size ? size : result;
    }

}
