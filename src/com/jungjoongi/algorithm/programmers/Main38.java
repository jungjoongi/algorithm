package com.jungjoongi.algorithm.programmers;


import java.util.HashSet;
import java.util.Set;

public class Main38 {

    public static void main(String[] args) {
        System.out.println(solution("AAAE"));
    }


    static final String MAPPING = "AEIOU";
    static final int[] RATE_OF_INCREASE = {781, 156, 31, 6, 1};

    public static int solution(String word) {
        int answer = word.length();

        for (int i = 0; i < word.length(); i++) {
            System.out.println(RATE_OF_INCREASE[i] + " x " +MAPPING.indexOf(word.charAt(i)));
            answer += (RATE_OF_INCREASE[i] * MAPPING.indexOf(word.charAt(i)));
        }

        return answer;
    }
}
