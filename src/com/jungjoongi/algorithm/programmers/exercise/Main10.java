package com.jungjoongi.algorithm.programmers.exercise;

import java.util.Arrays;
import java.util.Comparator;

public class Main10 {

    public static void main(String[] args) {

        int[] numbers = {3, 30, 34, 5, 9};


        System.out.println(solution2(numbers));

    }

    public static String solution1(int[] numbers) {

        Arrays.sort(numbers);
        String[] strArr = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(strArr, Comparator.reverseOrder());
        StringBuffer sb = new StringBuffer();
        String preValue = "";
        B :for(int i = 0; i < strArr.length; i++) {
            if(preValue.equals("")) {
                preValue = strArr[i];
                sb.append(preValue);
            } else {
                if(preValue.length() >= strArr[i].length() && preValue.charAt(0) == strArr[i].charAt(0)) {
                    char[] preArr = preValue.toCharArray();
                    char[] nowArr = strArr[i].toCharArray();
                    boolean isSwap = false;
                    A :for(int nowIdx = 0; nowIdx < nowArr.length; nowIdx++) {
                        try {
                            if(nowArr[nowIdx] > preArr[nowIdx+1]) {
                                sb.delete(sb.lastIndexOf(preValue), sb.length());
                                sb.append(strArr[i]).append(preValue);
                                isSwap = true;
                                break A;
                            }
                        } catch (Exception e) {
                            break A;
                        }

                    }
                    if(!isSwap) {
                        sb.append(strArr[i]);
                        preValue = strArr[i];
                    }
                } else {
                    sb.append(strArr[i]);
                    preValue = strArr[i];
                }
            }
        }
        return sb.toString();
    }

    public static String solution2(int[] numbers) {
        Arrays.sort(numbers);
        String[] strArr = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
        StringBuffer sb = new StringBuffer();
        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (b+a).compareTo(a+b);
                //오름차순 정렬 (o1+o2).compareTo(o1+o2);
            }
        });
        if (strArr[0].equals("0")) return "0";

        for(int i = 0; i < strArr.length; i++) {
            sb.append(strArr[i]);
        }

        return sb.toString();
    }

}
