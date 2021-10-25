package com.jungjoongi.algorithm.codility;


public class Exam_02 {
    public int[] solution(int[] A, int K) {
        int aSize = A.length;
        int[] resA = new int[aSize];

        for (int i = 0; i < aSize; i++) {
            int idx = (i + K) % aSize;
            resA[idx] = A[i];
        }
        return resA;
    }
}

class Main2 {
    public static void main(String[] args) {

        Exam_02 exam = new Exam_02();

        int[] A = {4,5,6,7,8};
        int K = 3;

        //System.out.println(A[A.length-3]);
        System.out.println(exam.solution(A,K));

    }

}

