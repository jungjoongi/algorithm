package com.jungjoongi.algorithm.programmers.exercise;



import java.util.Stack;

public class Main42 {

    public static void main(String[] args) {
        System.out.println(solution(3, new int[][] {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));

    }

    public static int solution(int n, int[][] computers) {
        boolean[] isVisit = new boolean[n];
        int answer = 0;

        for(int i = 0; i < n; i++) {

            if(!isVisit[i]) {
                dfs(i, computers, isVisit, n);
                answer++;
            }
        }
        return answer;
    }

    public static void dfs(int point, int[][] computers, boolean[] isVisit, int n) {
        Stack<Integer> stack = new Stack<>();
        stack.push(point);

        while (!stack.isEmpty()) {
            int now = stack.pop();
            for(int i = 0; i < n; i++) {
                if(i != now && !isVisit[i] && computers[now][i] == 1) {
                    isVisit[i] = true;
                    stack.push(i);
                }
            }
        }
    }
}
