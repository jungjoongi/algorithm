package com.jungjoongi.algorithm.programmers.exercise;

import java.util.*;

public class Main12 {

    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) {

        String numbers = "123";

        solution(numbers);

    }



    public static int solution(String numbers) {

        recursive("", numbers);
        int cnt = 0;
        for(int i : set) {
            if(isPrimeNumber(i)) {
                cnt++;
            }
        }

        return cnt;

    }

    public static boolean isPrimeNumber(int num) {

        if(num == 0 || num == 1) {
            return false;
        }

        int limit = (int)Math.sqrt(num);
        for(int j = 2; j <= limit; j++) {
            if(num % j == 0) {
                return false;
            }
        }
        return true;
    }

    public static void recursive(String str1, String str2) {

        if(!"".equals(str1)) {
            set.add(Integer.parseInt(str1));
        }

        for(int i = 0; i < str2.length(); i++) {
            recursive(str1 + str2.charAt(i), str2.substring(0,i) + str2.substring(i+1));
        }

    }



}
