package com.jungjoongi.algorithm.programmers.exercise;

import java.util.Arrays;

public class Main3 {

    public static void main(String[] args) {
        int N = 1;
        char[] ascArr = Integer.toString(N).toCharArray();
        Arrays.sort(ascArr);
        int asc = Integer.parseInt(String.valueOf(ascArr));
        StringBuilder sb = new StringBuilder(new String(ascArr, 0, ascArr.length));
        int desc = Integer.parseInt(sb.reverse().toString());
        int result = asc + desc;
        System.out.println(asc);
        System.out.println(desc);
    }

}
