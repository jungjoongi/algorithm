package com.jungjoongi.algorithm.codility;


import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

public class Exam_03 {
    public int solution(int[] A) {
        int aSize = A.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < aSize; i++) {
            int mapCnt = map.get(A[i]) == null ? 1 : map.get(A[i]) + 1;
            map.put(A[i], mapCnt);
        }
        int result = -1;
        for(int key : map.keySet()) {

            if(map.get(key) % 2 != 0) {
                result = map.get(key);
                break;
            }
        }
        return result;
    }
}

class Main3 {
    public static void main(String[] args) {

        Exam_02 exam = new Exam_02();

        int[] A = {4,5,6,7,8};
        AtomicReference<Integer> a = new AtomicReference<>(0);
        int returnValue = 0;
        boolean isIntegerCheck = false;
        Map<Boolean, Integer> map = new HashMap<>();
        A = Arrays.stream(A).distinct().sorted().toArray();
        int idx = A[0];// you can also use imports, for example:

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

        class Solution {
            public int solution(int[] A) {

                int returnValue = 0;
                boolean isIntegerCheck = false;
                A = Arrays.stream(A).distinct().sorted().toArray();
                int idx = A[0];

                for(int i = 0; i < A.length; i++) {
                    if(A[i] < 0) {
                        returnValue = 1;
                        isIntegerCheck = true;
                        break;
                    } else if (idx != A[i]) {
                        isIntegerCheck = true;
                        returnValue = idx;
                        break;
                    }
                    idx++;
                }
                if(!isIntegerCheck) {
                    returnValue = A[A.length-1] + 1;
                }


                return returnValue;
            }
        }


    }

}

