package com.jungjoongi.algorithm.programmers;

import java.util.HashSet;
import java.util.Set;

public class Main19 {

    public static void main(String[] args) {

        


    }


    /**
     * 월간 코드 챌린지 시즌3
     * @param numbers
     * @return
     */
    public int solution(int[] numbers) {

        Set<Integer> set = new HashSet<>();
        int answer = 0;
        for(int i = 0; i < 10; i++) {
            set.add(i);
        }
        for(int i : numbers) {
            set.remove(i);
        }
        for(int i : set) {
            answer += i;
        }

        return answer;
    }

}
