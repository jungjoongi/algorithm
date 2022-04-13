package com.jungjoongi.algorithm.programmers;

import java.util.*;

public class Main20 {

    public static void main(String[] args) {
        System.out.println("답 : "+solution(new int[][] {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}}, new int[]{1, 5, 3, 5, 1, 2, 1, 4}));

    }


    /**
     * 2019 카카오 개발자 겨울 인턴십 크레인 인형뽑기 게임
     * @param board
     * @param moves
     * @return
     */
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Map<Integer, Stack> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int j = board.length-1; j > -1; j--) {
            for(int i = 0; i < board[j].length; i++) {
                if(map.get(i) == null) {
                    map.put(i, new Stack<Integer>());
                    if(board[j][i] != 0) {
                        map.get(i).push(board[j][i]);
                    }
                } else {
                    if(board[j][i] != 0) {
                        map.get(i).push(board[j][i]);
                    }
                }
            }
        }

        for(int move : moves) {
            if(map.get(move-1).empty()) {
                continue;
            }
            int popData = (Integer)map.get(move-1).pop();
            System.out.println("*****");
            System.out.println(popData);
            System.out.println("------");


            if(!stack.empty() && stack.peek() == popData) {
                stack.pop();
                answer += 2;
            } else {
                stack.push(popData);
            }
            stack.stream().forEach(System.out::print);
            System.out.println();
            System.out.println("*****");
        }

        return answer;
    }

}
