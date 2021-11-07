package com.jungjoongi.algorithm.programers;

import java.util.*;
import java.util.stream.Stream;

public class Main11 {

    public static void main(String[] args) {

        int[] answers = {1,2,3,4,5};
        System.out.println(solution1(answers));

    }

    public static int[] solution1(int[] answers) {
        int[] no1 = {1, 2, 3, 4, 5};
        int[] no2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] no3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int no1Score = 0;
        int no2Score = 0;
        int no3Score = 0;
        int no1Cnt = 0;
        int no2Cnt = 0;
        int no3Cnt = 0;
        Map<Integer, Integer> map = new TreeMap<>();
        Set<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        for(int i = 0; i < answers.length; i++) {
            no1Cnt = no1Cnt > 4 ? 0 : no1Cnt;
            no2Cnt = no2Cnt > 7 ? 0 : no2Cnt;
            no3Cnt = no3Cnt > 9 ? 0 : no3Cnt;
            no1Score += answers[i] == no1[no1Cnt++] ? 1 : 0;
            no2Score += answers[i] == no2[no2Cnt++] ? 1 : 0;
            no3Score += answers[i] == no3[no3Cnt++] ? 1 : 0;
        }
        map.put(1, no1Score);
        map.put(2, no2Score);
        map.put(3, no3Score);

        int cnt = 1;
        int max = 0;
        int size = 0;
        int[] result = new int[3];
        for(int i : map.values()) {

            if(cnt == 1) {
                max = i;
            }

            if(max == map.get(cnt)) {
                result[size] = cnt;
                size++;
            }
            cnt++;
        }

        result = Arrays.copyOfRange(result,0, size);

        return result;

    }


}
