package com.jungjoongi.algorithm.programmers;


import com.sun.jdi.IntegerType;
import com.sun.jdi.IntegerValue;

import java.util.*;

public class Main35 {

    public static void main(String[] args) {
        System.out.println(solution(new int[][] {{0, 1, 1, 0},{0, 0, 0, 0},{0, 0, 0, 0},{0, 0, 0, 0}}));
    }



    public static int solution(int [][]board) {
        int result = 0;

        if(board.length == 1 && board[0].length == 1) {
            if(board[0][0] == 0) {
                return 0;
            } else {
                return 1;
            }
        }
        for(int y = 1; y < board.length; y++) {
            for(int x = 1; x < board[y].length; x++) {
                if(board[y][x] == 0) {
                    continue;
                }
                if(board[y-1][x-1] != 0) {
                    int min = Math.min(Math.min(board[y - 1][x], board[y][x - 1]), board[y - 1][x - 1]) + 1;
                    board[y][x] = min;
                    result = Math.max(result, min);
                }
            }
        }
        return result * result;
    }
}
