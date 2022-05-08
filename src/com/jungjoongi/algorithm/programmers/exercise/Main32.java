package com.jungjoongi.algorithm.programmers.exercise;


import java.util.*;
import java.util.stream.Collectors;

public class Main32 {

    public static void main(String[] args) {
        System.out.println(solution(new String[] {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"}));
    }

    static PriorityQueue<Integer> queue = null;

    public static int[] solution(String[] operations) {
        int[] answer = new int[2];
        queue = new PriorityQueue<>();

        for(int i = 0; i < operations.length; i++) {
            execute(operations[i].split(" "));
        }
        if(queue.size() == 0) {
            answer[0] = 0;
            answer[1] = 0;

        } else {
            answer[1] = queue.stream().max(Integer::compareTo).orElse(999);
            answer[0] = queue.poll();
        }
        return answer;
    }

    static void execute(String[] arr) {
        if("I".equals(arr[0])) {
            add(Integer.parseInt(arr[1]));
        } else {
            delete(arr);
        }
    }

    static void add(int i) {
        queue.offer(i);
    }

    static void delete(String[] arr) {
        if("1".equals(arr[1])) {
            int max = queue.stream().max(Integer::compareTo).get();
            queue.remove(max);
        } else {
            queue.poll();
        }
    }
}
