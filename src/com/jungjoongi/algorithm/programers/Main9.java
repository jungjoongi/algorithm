package com.jungjoongi.algorithm.programers;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main9 {

    public static void main(String[] args) {

        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1},{1, 7, 3}};

        System.out.println(solution1(array, commands));

    }

    public static int[] solution1(int[] array, int[][] commands) {
        int[] result = new int[commands.length];
        for(int i = 0; i < commands.length; i++) {
            int[] arr = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(arr);
            result[i] = arr[commands[i][2]-1];
        }


        return result;
    }

}
