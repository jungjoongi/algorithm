package com.jungjoongi.algorithm.codility;

import java.util.ArrayList;
import java.util.List;

public class Exam_01 {
    public int solution(int N) {
        String a = Integer.toBinaryString(N);
        return checkStr(a);
    }

    public int checkStr(String str) {

        String[] strArr = str.split("");
        List<Integer> strList = new ArrayList<>();

        for(int i = 0; i < strArr.length; i++) {
            if("1".equals(strArr[i])) {
                strList.add(i);
            }
        }
        int strListSize = strList.size();
        int max = 0;
        int now = 0;
        if(strListSize > 0) {
            for (int i = 0; i < strListSize-1; i++) {
                now = strList.get(i + 1) - strList.get(i);
                if (max < now) {
                    max = now;
                }
            }
        }
        return max+1;
    }
}

class Main {
    public static void main(String[] args) {
        Exam_01 e = new Exam_01();
        System.out.println(e.solution(1024));
        //e.solution(222);
    }
}
