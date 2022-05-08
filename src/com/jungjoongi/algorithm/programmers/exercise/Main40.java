package com.jungjoongi.algorithm.programmers.exercise;


import java.util.*;

public class Main40 {

    public static void main(String[] args) {
        System.out.println(solution(new int[] {3, 0, 6, 1, 5}));

    }

    public static int solution(int[] citations) {

        Arrays.sort(citations);
        int result = 0;
        for(int i = 0; i < citations.length; i++) {
            int h = citations.length - i;
            if(citations[i] >= h) {
                result = h;
                break;
            }
        }
        return result;
    }
}
