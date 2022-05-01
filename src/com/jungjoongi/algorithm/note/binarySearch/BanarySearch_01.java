package com.jungjoongi.algorithm.note.binarySearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BanarySearch_01 {
    public static void main(String[] args) {

        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < 1000; i++) {
           set.add((int)(Math.random()*10000000));
        }
        List<Integer> list = set.stream().sorted().collect(Collectors.toList());
        binarySearch(list, list.get(3));

    }

    public static void binarySearch(List<Integer> list, int standard) {

        System.out.println("standard : "+ standard);
        int start = 0;
        int end = list.size() - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if(standard > list.get(mid)) {
                start = mid + 1;
            } else {
                end = mid -1;
            }
        }

        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) == standard) {
                System.out.println("for search index : " + i);
                break;
            }
        }

        System.out.println("binarySearch index : " +  start);
        System.out.println("binarySearch 기준치 초과 개수 : " + (list.size()- start));

    }


}
