package com.jungjoongi.algorithm.programmers.exercise;


import java.util.*;

public class Main48 {

    public static void main(String[] args) {
        System.out.println(
            solution(new int[] {95, 90, 99, 99, 80, 99}, new int[] {1,1,1,1,1,1})
        );
    }


    public static int[] solution(int[] progresses, int[] speeds) {

        int day = 1;
        int job = 0;

        List<Integer> list = new ArrayList<>();
        while (true) {
            int gropCount = 0;
            if(progresses[job] + (speeds[job]*day) >= 100) {
                gropCount++;
                job++;
                for(int i = job; i < progresses.length; i++) {
                    if(progresses[i] + (speeds[i]*day) >= 100) {
                        job++;
                        gropCount++;
                    } else {
                        break;
                    }
                }
                list.add(gropCount);
                if(job >= progresses.length) {
                    break;
                }
            } else {
                day++;
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
