package com.jungjoongi.algorithm.note.dynamic;

public class 개념_메모이제이션_하향식 {

    public static long[] d = new long[100];

    public static void main(String[] args) {
        System.out.println(fibo(10));
    }
    /**
     * 다이나믹프로그래밍 하향식(메모이제이션)
     * 한번 구한 값을 메모리공간에 메모하는 구현방법 캐싱(caching)
     * @param x
     */
    public static long fibo(int x) {
        //System.out.print("f(" + x + ") ");
        if (x == 1 || x == 2) {
            return 1;
        }
        // 이미 계산한 적 있는 문제라면 그대로 반환
        if (d[x] != 0) {
            return d[x];
        }
        // 아직 계산하지 않은 문제라면 점화식에 따라서 피보나치 결과 반환
        d[x] = fibo(x - 1) + fibo(x - 2);
        return d[x];
    }

}
