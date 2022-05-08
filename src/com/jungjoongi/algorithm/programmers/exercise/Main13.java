package com.jungjoongi.algorithm.programmers.exercise;

import java.util.HashSet;
import java.util.Set;

public class Main13 {

    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) {

        int brown = 20;
        int yellow = 5;

        solution(brown, yellow);

    }



    public static int[] solution(int brown, int yellow) {

        int[] result = new int[2];
        int area = brown + yellow;

        for(int i = 1; i < area; i++) {
            if(area % 1 == 0) {
                if(i > area/i) {
                    break;
                }
                result[0] = area/i;
                result[1] = i;
            }

        }


        return result;
    }




}
