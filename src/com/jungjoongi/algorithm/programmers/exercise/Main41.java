package com.jungjoongi.algorithm.programmers.exercise;


import java.util.*;
import java.util.stream.Collectors;

public class Main41 {

    public static void main(String[] args) {
        System.out.println(solution(new int[][] {{0, 3}, {1, 9}, {2, 6}}));

    }

    public static int solution(int[][] jobs) {
        Queue<int[]> jobQueue = new PriorityQueue<>((o1, o2) ->  o1[0] - o2[0]);
        Queue<int[]> jobQueue2 = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        for(int[] i : jobs) {
            jobQueue.offer(i);
        }

        int count = 0;
        int time = 0;
        int allRunningTime = 0;

        while (count < jobs.length) {
            while(!jobQueue.isEmpty() && time >= jobQueue.peek()[0]) {
                int[] temp = jobQueue.poll();
                jobQueue2.offer(temp);
            }
            if (!jobQueue2.isEmpty()) {
                int[] nowJob = jobQueue2.poll();
                allRunningTime +=  nowJob[1] +(time - nowJob[0]);
                time += nowJob[1];
                count++;
            } else {
                time++;
            }
        }

        return allRunningTime/count;
    }
}
