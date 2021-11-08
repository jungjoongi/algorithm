package com.jungjoongi.algorithm.programmers;

import java.util.*;

public class Main8 {

    public static void main(String[] args) {

        int[] scoville = {1, 2, 3, 9, 10, 12};
        int K = 7;

        System.out.println(solution1(scoville, K));

    }

    public static int solution1(int[] scoville, int K) {

        Queue<Long> queue = new PriorityQueue<>();

        for(long i : scoville) {
            queue.offer(i);
        }
        boolean isDone = false;
        int result = 0;
        if(queue.size() == 0) {
            return -1;
        }

        while(!isDone) {
            long min1 = queue.poll();
            long min2 = queue.poll();
            if(min1 + min2 == 0 || result >= scoville.length) {
                return -1;
            }
            if(min1 >= K) {
                break;
            }

            queue.offer(min1 + min2*2);
            result++;
        }

        return result;
    }

}
