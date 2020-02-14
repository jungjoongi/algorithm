package com.jungjoongi.algorithm.step01;

public class Default {

    /*
        최대값 최소값 구하는 문제
     */

    public static void main(String[] args) {
        //최대값
        System.out.println(max4(11,6,7,2));
        //최소값
        System.out.println(min3(22,13,5));
        //중앙값
        System.out.println(middle3(7677,413,25));
    }

    static int max4(int a, int b, int c,int d) {
        int max = a;

        if (max < b) {
            max = b;
        }

        if (max < c) {
            max = c;
        }

        if (max < d) {
            max = d;
        }

        return max;
    }

    static int min3(int a, int b, int c) {
        int min = a;

        if (min > b) {
            min = b;
        }

        if (min > c) {
            min = c;
        }
        return min;

    }

    static int middle3(int a, int b, int c) {
        int min = a;

        if ((a > b && b > c) || (c > b && b > a)) {
            return b;
        } else if ((b > c && c > a)|| (a > c && c > b)) {
            return c;
        } else  {
            return a;
        }

    }
}
