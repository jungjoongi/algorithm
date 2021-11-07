package com.jungjoongi.algorithm.programers;

import java.util.HashMap;
import java.util.Map;

public class Main2 {

    public static void main(String[] args) {


        int[] A = {7, 4, -2, 4, -2, -9};
        int size = A.length;

        int maxCnt = 0;
        int cnt = 2;
        int preEven = A[0];
        int preOdd = A[1];

        for(int i = 2 ; i < size; i++) {
            if(i % 2 == 0) {
                System.out.println("짝 : " + A[i] +" : " + preEven);
                if(A[i] == preEven) {
                    cnt++;
                } else {
                    cnt = 2;
                }
                preEven = A[i];
            } else {
                System.out.println("홀 : " + A[i] +" : " + preOdd);
                if(A[i] == preOdd) {
                    cnt++;
                } else {
                    cnt = 2;
                }
                preOdd = A[i];
            }
            if(maxCnt < cnt) {
                maxCnt = cnt;
            }
        }
        System.out.println(maxCnt);
    }

}
