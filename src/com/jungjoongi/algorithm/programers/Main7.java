package com.jungjoongi.algorithm.programers;

import java.util.*;
import java.util.stream.Collectors;

public class Main7 {

    public static void main(String[] args) {

        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;

//        int[] priorities = {2, 1, 3, 2};
//        int location = 2;
        System.out.println(solution2(priorities, location));

    }

    public static int solution1(int[] priorities, int location) {
        Queue<Integer> queue = new LinkedList<>();

        int myLocation = priorities[location];
        int[] sortArr = Arrays.stream(priorities).sorted().toArray();
        //int max = Arrays.stream(priorities).max().getAsInt();

        //System.out.println(priorities[ sortArr.length-1]);

        for(int i = 0; i < priorities.length; i++) {
            queue.add(i);
        }


        int cnt = 1;
        for(int i = sortArr.length-1; i >= 0; i--) {
            int max = sortArr[i];
            int queuePop = queue.poll();
            int item = sortArr[queuePop];
            if(max > item) {
                queue.add(i);
                if(queuePop == location) {
                    location = sortArr.length-1;
                } else {
                    location--;
                }
                cnt++;
            } else if(queuePop == location) {
                return i;
            }
        }

        return cnt;
    }

    public static int solution2(int[] priorities, int location) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Integer> originQueue = new LinkedList<>();

        for(int i : priorities) {
            queue.offer(i);
        }
        for(int i = 0; i < priorities.length; i++) {
            originQueue.offer(i);
        }

        int result = 1;
        while(!originQueue.isEmpty()) {
            int originIndex = originQueue.poll();
            int originValue = priorities[originIndex];
            int maxValue = queue.peek();
            if(originValue < maxValue) {
                originQueue.offer(originIndex);
            } else if (originValue == maxValue) {
                if(originIndex == location) {
                    return result;
                } else {
                    queue.remove();
                    result++;
                }
            }
        }
        return result;
    }

}
