package com.jungjoongi.algorithm.programmers;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main30 {

    public static void main(String[] args) {

    }


    public static int solution(int n, int[] lost, int[] reserve) {
        int rentCount = 0;
        Set<Integer> reserveSet = new HashSet<>();
        Arrays.sort(lost);
        Arrays.sort(reserve);
        boolean[] isRent = new boolean[lost.length];
        for(int i : reserve) {
            reserveSet.add(i);
        }
        for(int i = 0; i < lost.length; i++) {
            if(reserveSet.contains(lost[i])) {
                reserveSet.remove(lost[i]);
                isRent[i] = true;
                rentCount++;
            }
        }
        for(int i = 0; i < lost.length; i++) {

            if(isRent[i]) {
                continue;
            }
            if(reserveSet.contains(lost[i]-1)) {
                reserveSet.remove(lost[i] -1);
                isRent[i] = true;
                rentCount++;
            } else if (reserveSet.contains(lost[i]+1)) {
                reserveSet.remove(lost[i] + 1);
                isRent[i] = true;
                rentCount++;
            }
        }
        return n - (lost.length - rentCount);
    }
}
