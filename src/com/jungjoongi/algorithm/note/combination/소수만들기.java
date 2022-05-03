package com.jungjoongi.algorithm.note.combination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class 소수만들기 {

    public static void main(String[] args) {
        System.out.println(solution(new int[] {1,2,3,4}));
    }

    public static int solution(int[] nums) {
        int r = 3;
        List<Integer> sumList = new ArrayList<>();
        combination(0, nums, r, sumList, 0);
        return sumList.stream().reduce((n1, n2) -> n1 + n2).orElse(0);
    }

    public static void combination(int sum, int[] nums, int r, List<Integer> sumList , int index ){
        int n = nums.length;
        if(r == 0) {
            if(isPrime(sum)) {
                sumList.add(1);
            }
            return;
        }
        for(int i = index; i < n; i++) {
            combination(sum + nums[i], nums, r-1, sumList, i + 1);
        }
    }

    public static boolean isPrime(int num) {
        for(int j = 2; j <= (int)Math.sqrt(num); j++) {
            if(num % j == 0) {
                return false;
            }
        }
        return true;
    }
}
