package com.jungjoongi.algorithm.programmers.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Skill_Check_01 {
    static int result = 0;
    public static void main(String[] args) {

        System.out.println(solution(15));

    }

    public static int solution(int n) {
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            list.add(i+1);
        }
        combination( list, 0, n);
        return result;
    }

    public static void combination(List<Integer> num, int index, int max) {

        if(index == max) {
            return;
        }
        combination(num, index+1, max);
        int sum = 0;
        for(int i = index; i < num.size(); i++) {
            sum += num.get(i);
            if(sum == max) {
                result++;
            } else if (sum > max) {
                return;
            }
        }
    }
}
