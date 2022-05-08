package com.jungjoongi.algorithm.note.combination;

import java.util.ArrayList;
import java.util.List;

public class 예산 {

    public static void main(String[] args) {
        System.out.println(solution(new int[] {2, 2, 3, 3}, 10));
    }

    public static int max = 0;
    public static int[][] dp = new int[Integer.MAX_VALUE][Integer.MAX_VALUE];
    public static int solution(int[] d, int budget) {
        int r = d.length;
        List<Integer> sumList = new ArrayList<>();
        combination(0, d, r, budget, 0, 0);
        return max;
    }

    public static void combination(int sum, int[] d, int r, int budget , int index, int count ){
        int n = d.length;
        if(r == 0){
            max = Math.max(max, count);
            return;
        }
        for(int i = index; i < n; i++) {
            if(sum + d[i] <= budget) {
                combination(sum + d[i], d, r-1, budget, i + 1, count+1);
            } else {
                max = Math.max(max, count);
                return;
            }
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
