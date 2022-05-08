package com.jungjoongi.algorithm.programmers.exercise;


import java.util.*;
import java.util.stream.Collectors;

public class Main31 {

    public static void main(String[] args) {
        System.out.println(solution("1924", 2));
    }


    public static String solution(String number, int k) {

        char[] numArr = number.toCharArray();
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for(int i = 0; i < number.length() - k; i++) {
            char max = '0';
            for(int i2 = index; i2 <= i+k; i2++) {
                char now = numArr[i2];
                System.out.println(i + " : " + i2 + " : " + now);
                if(max < now) {
                    max = now;
                    index = 1+i2;
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }
}
