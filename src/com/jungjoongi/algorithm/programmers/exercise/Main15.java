package com.jungjoongi.algorithm.programmers.exercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main15 {

    public static void main(String[] args) {

        solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19});


    }


    /**
     * [카카오인턴쉽] 로또의 최고 순위와 최저 순위
     * @param lottos
     * @param win_nums
     * @return
     */
    public static int[] solution(int[] lottos, int[] win_nums) {
        int unknownCount = 0;
        int matchCount = 0;
        for(int lotto : lottos) {
            if(lotto == 0) {
                unknownCount++;
            } else {
                for(int min_num : win_nums) {
                    if(lotto == min_num) {
                        matchCount++;
                    }
                }

            }
        }

        int minGrade = 0;
        int maxGrade = 0;
        if(matchCount == 0 || matchCount == 1 ) {
            minGrade = 6;
        } else if(matchCount == 2) {
            minGrade = 5;
        } else if(matchCount == 3) {
            minGrade = 4;
        } else if(matchCount == 4) {
            minGrade = 3;
        } else if(matchCount == 5) {
            minGrade = 2;
        } else {
            minGrade = 1;
        }


        System.out.println(matchCount + " : " + minGrade)  ;
        if(matchCount + unknownCount < 2) {
            maxGrade = 6;
        } else if(matchCount + unknownCount == 2) {
            maxGrade = 5;
        } else if(matchCount + unknownCount == 3) {
            maxGrade = 4;
        } else if(matchCount + unknownCount == 4) {
            maxGrade = 3;
        } else if(matchCount + unknownCount == 5) {
            maxGrade = 2;
        } else {
            maxGrade = 1;
        }
        int[] answer = {maxGrade, minGrade};
        return answer;
    }

}
