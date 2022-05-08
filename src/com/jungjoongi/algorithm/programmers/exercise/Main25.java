package com.jungjoongi.algorithm.programmers.exercise;


import java.util.*;

public class Main25 {

    public static void main(String[] args) {

        System.out.println(solution("one4seveneight"));
    }

    public static int solution(String s) {
        String answer = "";
        Set<String> numSet = new HashSet<>();
        Map<String, String> wordMap = new HashMap<>();

        numSet.add("0");
        numSet.add("1");
        numSet.add("2");
        numSet.add("3");
        numSet.add("4");
        numSet.add("5");
        numSet.add("6");
        numSet.add("7");
        numSet.add("8");
        numSet.add("9");

        wordMap.put("zero", "0");
        wordMap.put("one", "1");
        wordMap.put("two", "2");
        wordMap.put("three", "3");
        wordMap.put("four", "4");
        wordMap.put("five", "5");
        wordMap.put("six", "6");
        wordMap.put("seven", "7");
        wordMap.put("eight", "8");
        wordMap.put("nine", "9");

        String mix = "";
        for(String word : s.split("")) {
            mix += word;

            if(numSet.contains(mix)) {
                answer += mix;
                mix = "";
            } else {

                if(wordMap.get(mix) != null) {
                    answer += wordMap.get(mix);
                    mix = "";
                }
            }
        }
        return Integer.parseInt(answer);
    }

}
