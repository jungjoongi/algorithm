package com.jungjoongi.algorithm.programmers.exercise;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main26 {

    public static void main(String[] args) {

        System.out.println(solution(8, 4, 7));
    }

    public static int solution(int n, int a, int b) {
        int answer = 0;
        int matchCount = n /2 ;
        int aLocate = a;
        int bLocate = b;
        for(int i = 0; i < matchCount; i++) {
            aLocate = aLocate / 2;
            bLocate = bLocate / 2;
            if(aLocate == bLocate) {
                answer = i+1;
                break;
            }
        }

        return answer;
    }

}
