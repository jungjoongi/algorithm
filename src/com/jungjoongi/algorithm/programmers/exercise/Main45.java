package com.jungjoongi.algorithm.programmers.exercise;


import java.util.*;

public class Main45 {

    public static void main(String[] args) {

        System.out.println(solution(2, new String[] {"hello", "one", "even", "never", "now", "world", "draw"}));
    }


    /**
     * 끝맛잇기
     * 스킬 체크 테스트 Level.2
     * @param n
     * @param words
     * @return
     */
    public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> set = new HashSet<>();
        int who = 1;
        String beforeWord = "";
        for(int i = 0; i < words.length; i++) {
            if(i > 0) {
                beforeWord = words[i - 1];
            }
            if(who > n) {
                who = 1;
            }
            if(set.contains(words[i])) {
                answer[0] = who;
                answer[1] = (i+1) % n == 0 ? (i+1)/n : (i+1)/n + 1;
                break;
            } else if(i > 0 && beforeWord.charAt(beforeWord.length()-1) != words[i].charAt(0)) {
                answer[0] = who;
                answer[1] = (i+1) % n == 0 ? (i+1)/n : (i+1)/n + 1;
                break;
            } else {
                set.add(words[i]);
            }
            who++;
        }
        return answer;
    }


}
