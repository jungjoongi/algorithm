package com.jungjoongi.algorithm.programmers;


import java.util.Arrays;

public class Main22 {

    public static void main(String[] args) {
        solution(new int[][] {{60, 50}, {30, 70}, {60, 30}, {80, 40}});
    }
    /**
     *  스킬 체크 테스트 Level.1
     * @param sizes
     * @return
     */
    public static int solution(int[][] sizes) {
        int widthMax = 0;
        int heightMax = 0;
        for (int size[] : sizes) {
            int swap = 0;
            if(size[0] < size[1]) {
                swap = size[0];
                size[0] = size[1];
                size[1] = swap;
            }
            if(widthMax == 0) {
                widthMax = size[0];
            } else if (size[0] > widthMax) {
                widthMax = size[0];
            }

            if(heightMax == 0) {
                heightMax = size[1];
            } else if (size[1] > heightMax) {
                heightMax = size[1];
            }
        }

        return widthMax * heightMax;
    }

}
