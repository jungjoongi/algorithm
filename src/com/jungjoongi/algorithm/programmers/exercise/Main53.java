package com.jungjoongi.algorithm.programmers.exercise;


import java.util.*;
import java.util.stream.Collectors;

public class Main53 {

    public static void main(String[] args) {

        System.out.println(
                solution(new String[] {"sun", "bed", "car"}, 1)
        );
    }

    public static String[] solution(String[] strings, int n) {

        return Arrays.stream(strings).sorted((o1, o2) -> {
            if(o1.charAt(n) == o2.charAt(n)) {
                return o1.compareTo(o2);
            } else {
                return o1.charAt(n) - o2.charAt(n);
            }
        }).toArray(String[]::new);
    }
}