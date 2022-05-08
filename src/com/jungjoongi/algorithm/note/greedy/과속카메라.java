package com.jungjoongi.algorithm.note.greedy;


import java.util.*;

public class 과속카메라 {

    public static void main(String[] args) {
        System.out.println(
            solution(new int[][]{{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}})
        );
    }


    /**
     * 과속카메라
     * 1. 차랑 out 시점으로 정렬
     * 2. 최초 차량 out 시점에 카메라 설치
     * 3. 다음차량 진입시점이 카메라 위치보다 크다면 신규카메라 설치
     * @param routes
     * @return
     */
    public static int solution(int[][] routes) {

        Arrays.sort(routes, (o1, o2) -> {
            return o1[1] - o2[1];
        });
        int answer = 0;

        int camera = Integer.MIN_VALUE;
        for(int[] route :  routes) {
            if(route[0] > camera) {
                camera = route[1];
                answer++;
            }
        }
        return answer;
    }
}
