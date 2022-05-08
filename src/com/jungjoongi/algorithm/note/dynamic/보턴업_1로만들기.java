package com.jungjoongi.algorithm.note.dynamic;

public class 보턴업_1로만들기 {

    // 앞서 계산된 결과를 저장하기 위한 DP 테이블 초기화
    public static int[] d = new int[30001];

    public static void main(String[] args) {

        int x = 26;

        // 다이나믹 프로그래밍(Dynamic Programming) 진행(보텀업)
        for (int i = 2; i <= x; i++) {
            // 현재의 수에서 1을 빼는 경우
            d[i] = d[i - 1] + 1;
            System.out.println(">>" + i + " : " +d[i]);
            // 현재의 수가 2로 나누어 떨어지는 경우
            if (i % 2 == 0) {
                d[i] = Math.min(d[i], d[i / 2] + 1);
                System.out.println("%2 : " + d[i] + " : " + (d[i / 2] + 1));
            }
            // 현재의 수가 3으로 나누어 떨어지는 경우
            if (i % 3 == 0) {
                d[i] = Math.min(d[i], d[i / 3] + 1);
                System.out.println("%3 : "+d[i] + " : " + (d[i / 3] + 1));
            }
            // 현재의 수가 5로 나누어 떨어지는 경우
            if (i % 5 == 0) {
                d[i] = Math.min(d[i], d[i / 5] + 1);
                System.out.println("%5 : "+d[i] + " : " + (d[i / 5] + 1));
            }
        }

        System.out.println(d[x]);
    }

}
