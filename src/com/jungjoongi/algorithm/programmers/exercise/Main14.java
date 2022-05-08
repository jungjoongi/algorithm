package com.jungjoongi.algorithm.programmers.exercise;

import java.util.*;

public class Main14 {

    public static void main(String[] args) {

        solution(new int[]{1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right");


    }


    /** [카카오 인턴] 키패드 누르기
     *
     * @param numbers
     * @param hand
     * @return
     */
    public static String solution(int[] numbers, String hand) {
        String answer = "";

        Map<Integer, Integer[]> location = new HashMap<>();
        Integer[] lPointer = {3,0};
        Integer[] rPointer = {3,2};
        location.put(1, new Integer[]{0,0});
        location.put(2, new Integer[]{0,1});
        location.put(3, new Integer[]{0,2});
        location.put(4, new Integer[]{1,0});
        location.put(5, new Integer[]{1,1});
        location.put(6, new Integer[]{1,2});
        location.put(7, new Integer[]{2,0});
        location.put(8, new Integer[]{2,1});
        location.put(9, new Integer[]{2,2});
        location.put(0, new Integer[]{3,1});

        for(int num : numbers) {
            if(num == 1 || num == 4 ||  num == 7) {
                answer += "L";
                lPointer = location.get(num);
            } else if (num == 3 || num == 6 ||  num == 9) {
                answer += "R";
                rPointer = location.get(num);
            } else {
                int x = location.get(num)[0];
                int y = location.get(num)[1];
                int leftDistance = Math.abs(lPointer[0] - x) + Math.abs(lPointer[1] - y);
                int rightDistance = Math.abs(rPointer[0] - x) + Math.abs(rPointer[1] - y);

                if(leftDistance < rightDistance) {
                    answer += "L";
                    lPointer = location.get(num);
                } else if(leftDistance > rightDistance) {
                    answer += "R";
                    rPointer = location.get(num);
                } else {
                    if("right".equals(hand)) {
                        rPointer = location.get(num);
                        answer += "R";
                    } else {
                        lPointer = location.get(num);
                        answer += "L";
                    }
                }
            }
        }
        return answer;
    }

}
