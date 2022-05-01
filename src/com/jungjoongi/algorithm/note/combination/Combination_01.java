package com.jungjoongi.algorithm.note.combination;

import java.util.Arrays;

public class Combination_01 {

    public static void main(String[] args) {

        String[] iArr = new String [10];
        int r = 3;
        for(int i = 0; i < 10; i++) {
            iArr[i] = Integer.toString(i);
        }
        String str = Arrays.stream(iArr).reduce((s1, s2) -> {
            return s1+s2;
        }).orElse("");
        combination("",str, r);
    }

    /**
     * #combination, nCr=n-1Cr-1 + n=1Cr 공식, #조합
     * @param preStr
     * @param maxStr
     * @param r
     */
    public static void combination(String preStr, String maxStr, int r) {
        int n = maxStr.length();
        if(r == 0) {
            System.out.println(preStr);
            return;
        }
        for(int i = 0; i < n; i++) {
            combination(preStr+maxStr.charAt(i), maxStr.substring(i+1), r-1);
        }
    }
}
