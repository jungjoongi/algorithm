package com.jungjoongi.algorithm.programers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main6 {

    public static void main(String[] args) {

        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        solution2(progresses, speeds);
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] temp = new int[progresses.length];
        int[] answer = new int[progresses.length];

        Map<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < progresses.length; i++) {
            int progress = progresses[i];
            int speed = speeds[i];
            int key = 0;
            if(progress + speed >= 100) {
                key = 1;
            } else if((100-progress) % speed == 0) {
                key = (100-progress) / speed;
            } else {
                key = (100-progress) / speed + 1;
            }
            temp[i] = key;
        }
        int cnt = 0;
        int preValue = 0;
        Arrays.stream(temp).forEach(System.out::println);
        for(int i = 0; i < temp.length; i++) {
            if(i == 0) {
                preValue = temp[i];
                answer[cnt] = 1;
            } else {
                if(temp[i] <= preValue) {
                    answer[cnt] = answer[cnt]+1;
                } else {
                    cnt++;
                    answer[cnt] = 1;
                    preValue = temp[i];
                }
            }
        }
        answer = Arrays.stream(answer).filter(i -> i!=0).toArray();
        Arrays.stream(answer).forEach(System.out::println);

        return answer;
    }

    public static int[] solution2(int[] progresses, int[] speeds) {
        int[] dayOfend = new int[100];
        int day = -1;
        for(int i=0; i<progresses.length; i++) {
            while(progresses[i] + (day*speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }
        Arrays.stream(dayOfend).forEach(System.out::println);
        return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
    }
}
