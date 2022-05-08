package com.jungjoongi.algorithm.programmers.exercise;


import java.util.Stack;

public class Main29 {

    public static void main(String[] args) {

        System.out.println(solution(new int[]{1, 1, 1, 1, 1}, 3));
    }


    public static int count = 0;
    /**
     * 깊이/너비 우선 탐색(DFS/BFS) (이건 DFS)
     * 타겟 넘버
     * @param numbers
     * @param target
     * @return
     */
    public static int solution(int[] numbers, int target) {

        dfs(numbers, 0, 0 + numbers[0], target);
        dfs(numbers, 0, 0 - numbers[0], target);

        return count;
    }


    public static void dfs(int[] numbers, int index, int sum, int target) {


        if((numbers.length -1 ) == index) {
            System.out.println(sum);
            if(sum == target) {
                count++;
            }
            return;
        } else {
            dfs(numbers, index+1, sum + numbers[index+1], target);
            dfs(numbers, index+1, sum - numbers[index+1], target);
        }
    }

}
