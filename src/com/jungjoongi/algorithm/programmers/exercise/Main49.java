package com.jungjoongi.algorithm.programmers.exercise;


import java.util.*;

public class Main49 {

    public static void main(String[] args) {

        System.out.println(
                solution(2, 10, new int[] {7,4,5,6})
        );
    }


    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i : truck_weights) {
            queue.offer(i);
        }
        int time = bridge_length;
        Queue<Integer> tempQ = new LinkedList<>();
        int bridgeWeight = 0;
        while (!queue.isEmpty()) {

            int queuePoll = 0;
            if(tempQ.isEmpty()) {
                queuePoll = queue.poll();
                tempQ.offer(queuePoll);
                bridgeWeight += queuePoll;
            } else {
                if(tempQ.size() == bridge_length) {
                    bridgeWeight -= tempQ.poll();
                }
                if(weight >= bridgeWeight + queue.peek()) {
                    queuePoll = queue.poll();
                    tempQ.offer(queuePoll);
                    bridgeWeight += queuePoll;
                } else {
                    if(bridgeWeight > weight) {
                        bridgeWeight -= tempQ.poll();
                    } else {
                        tempQ.offer(0);
                    }
                }
            }
            time++;
        }
        return time;
    }
}
