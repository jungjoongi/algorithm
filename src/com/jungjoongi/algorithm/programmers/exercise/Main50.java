package com.jungjoongi.algorithm.programmers.exercise;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main50 {

    public static void main(String[] args) {

        System.out.println(
                solution(new int[] {1, 2, 3, 2, 3})
        );
    }


    public static int[] solution(int[] prices) {
        int[] result = new int[prices.length];

        for(int current = 0; current < prices.length; current++) {
            if(current == prices.length -1 && prices[current-1] < prices[current]) {
                result[current] = 0;
            }
            int time = 0;
            for(int diffPoint = current+1; diffPoint < prices.length; diffPoint++) {
                time++;
                if(prices[current] > prices[diffPoint]) {
                    break;
                }

            }
            result[current] = time;
        }
        return result;


    }
}
