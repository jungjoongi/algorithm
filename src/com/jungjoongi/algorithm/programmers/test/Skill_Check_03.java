package com.jungjoongi.algorithm.programmers.test;

import java.util.Stack;

public class Skill_Check_03 {
    public static void main(String[] args) {

        System.out.println(solution(new int[][] {{1, 4}, {3, 2}, {4, 1}}, new int[][] {{3, 3}, {3, 3}}));

    }

    /**
     * 코딩테스트 연습
     * 연습문제
     * 행렬의 곱셈
     * 다른 사람의 풀이
     * https://programmers.co.kr/learn/courses/30/lessons/12949
     * @param arr1
     * @param arr2
     * @return
     */
    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];

        for(int y = 0; y < answer.length; y++) {
            for(int x = 0; x < answer[y].length; x++) {
                for(int k = 0; k < arr1[0].length; k++){
                    answer[y][x] += arr1[y][k] * arr2[k][x];
                }
            }
        }
        return answer;
    }
}
