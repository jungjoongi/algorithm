package com.jungjoongi.algorithm.note.greedy;


import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class 구명보트 {

    public static void main(String[] args) {

        solution(new int[] {70, 50, 80, 50}, 100);
    }

    public static int solution(int[] people, int limit) {

        Arrays.sort(people);
        Deque<Integer> deque = new LinkedList<>();
        for(int i : people) {
            deque.offer(i);
        }

        int count = 0;
        while (!deque.isEmpty()) {

            if(deque.size() > 1) {
                if(limit >= deque.peekFirst() + deque.peekLast()) {
                    deque.pollLast();
                    deque.pollFirst();
                    count++;
                } else {
                    deque.pollLast();
                    count++;
                }
            } else {
                deque.poll();
                count++;
            }
        }
        return count;
    }
}
