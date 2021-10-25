package com.jungjoongi.algorithm.hash;

import java.util.Arrays;
import java.util.Collections;

public class Hash_02 {

    public static void main(String[] args) {
        String[] phone_book = {"119", "97674223", "1195524421"};
        System.out.println(solution(phone_book));
    }

    public static boolean solution(String[] phone_book) {

        String[] phoneBookAsc = phone_book;
        String[] phoneBookDesc = phone_book;
        Arrays.sort(phoneBookAsc);
        Arrays.sort(phoneBookAsc, Collections.reverseOrder());

        for(String s1 : phoneBookAsc) {
            for(String s2 : phoneBookDesc) {
                if(s1.equals(s2)) continue;
                else if(s1.length() < s2.length()) {

                    if(s2.startsWith(s1)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
