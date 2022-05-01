package com.jungjoongi.algorithm.programmers.test;

public class Skill_Check_05 {
    public static void main(String[] args) {

        System.out.println(solution(new int[] {1, 2, 3, 2, 3}));

    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        rec(prices, 0, answer);
        return answer;
    }

    public static void rec(int[] prices, int index, int[] answer) {

        if(index == prices.length) {
            return;
        }
        int count = 0;
        for(int i = index+1; i < prices.length; i++) {

            if(prices[index] > prices[i]) {
                count++;
                break;
            } else {
                count++;
            }
        }
        answer[index] = count;
        rec(prices, index+1, answer);
    }
}
