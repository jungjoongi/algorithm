package com.jungjoongi.algorithm.programmers.exercise;


import java.util.*;
import java.util.stream.Collectors;

public class Main47 {

    public static void main(String[] args) {
        System.out.println(
            solution(new String[] {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[] {2,3,5})
        );
    }


    /**
     * 코딩테스트 연습
     * 2021 KAKAO BLIND RECRUITMENT
     * 메뉴 리뉴얼
     * https://programmers.co.kr/learn/courses/30/lessons/72411
     * @param orders
     * @param course
     * @return
     * 공식 : nCr = n-1Cr-1 + n-1Cr
     * 1. 각 주문별로 코스조합을 구한다. #combination 알고리즘 구현.
     * 2. 1이상인 max값을 구한다.
     * 3. list에 담아 정렬
     * 4. 리턴
     */
    public static String[] solution(String[] orders, int[] course) {
        for(int i = 0; i < orders.length; i++) {
            char[] cArray = orders[i].toCharArray();
            Arrays.sort(cArray);
            orders[i] = String.valueOf(cArray);
        }
        List<String> result = new ArrayList<>();
        for(int courseLength : course) {
            Map<String, Integer> courseMap = new HashMap<>();
            for(String order : orders) {
                combination("", order,  courseLength, courseMap);
            }
            int maxCount = new ArrayList<>(courseMap.values()).stream().mapToInt(x -> x).max().orElse(0);

            for(String key : courseMap.keySet()) {
                int value = courseMap.get(key);
                if(value == maxCount && maxCount > 1) {
                    result.add(key);
                }
            }
        }
        return result.stream().sorted().toArray(String[]::new);
    }

    public static void combination(String order, String others, int r, Map<String,Integer> courseMap) {
        int n = others.length();
        if(r == 0) {
            courseMap.put(order, courseMap.getOrDefault(order, 0) +1);
            return;
        }
        for(int i = 0 ; i < n; i++) {
            combination(order+others.charAt(i), others.substring(i+1), r - 1, courseMap);
        }
     }
}
