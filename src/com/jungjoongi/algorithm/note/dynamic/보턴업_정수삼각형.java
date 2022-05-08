package com.jungjoongi.algorithm.note.dynamic;

public class 보턴업_정수삼각형 {

    static int max = 0;
    public static void main(String[] args) {
        solution(new int[][] {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}});
    }

    public static int solution(int[][] triangle) {

        int[][] dp = triangle;
        for(int y = triangle.length-2; y >= 0; y--) {
            for(int x = 0; x < triangle[y].length; x++) {
                dp[y][x] = dp[y][x] + Math.max(dp[y+1][x], dp[y+1][x+1]);
            }
        }
        return dp[0][0];

    }


}
