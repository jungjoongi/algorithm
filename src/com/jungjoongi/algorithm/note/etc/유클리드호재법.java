package com.jungjoongi.algorithm.note.etc;

public class 유클리드호재법 {
    public static void main(String[] args) {
        int a = 2;
        int b = 16;
        int min = (a < b) ? a : b; // 참이면 a이고 아니면 b 인거지.
        int gcd = 0;
        for (int i = 1; i <= min; i++) {
            if (a % i == 0 && b % i == 0) gcd = i;
        }
        System.out.println("최대공약수 : " + gcd);
        System.out.println("최소공배수 : " + a * b / gcd);
    }

}
