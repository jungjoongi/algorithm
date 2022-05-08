package com.jungjoongi.algorithm.programmers.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main18 {

    public static void main(String[] args) {




    }


    /**
     * 카카오 월간 코드 챌린지 시즌2 음양 더하기
     * @param absolutes
     * @param signs
     * @return
     */
    public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for(int i = 0; i <  absolutes.length; i++) {
            answer += signs[i] ? absolutes[i] * 1 : absolutes[i] * -1;

        }

        return answer;
    }

}
