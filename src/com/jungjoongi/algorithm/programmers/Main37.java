package com.jungjoongi.algorithm.programmers;


import java.util.*;

public class Main37 {

    public static void main(String[] args) {
        System.out.println(solution("Asd asdsa 2d1 asd  dsad    dasdas "));
    }



    public static String solution(String s) {
        String answer = "";
        Set<Character> numSet = new HashSet<>();
        numSet.add('1');
        numSet.add('2');
        numSet.add('3');
        numSet.add('4');
        numSet.add('5');
        numSet.add('6');
        numSet.add('7');
        numSet.add('8');
        numSet.add('9');
        numSet.add('0');

        if("".equals(s)) {
            return "";
        }
        String[] strArr = s.split(" ");
        int count = 0;
        String prefix = "";
        for(String word : strArr) {
            if(count > 0) {
                prefix = " ";
            }
            if("".equals(word)) {
                answer+= prefix+word;
            } else if (numSet.contains(word.charAt(0))) {
                answer += prefix + Character.toString(word.charAt(0)) + word.substring(1, word.length()).toLowerCase();
            } else {
                String lowerWord = word.toLowerCase();
                String[] lowerWordArr = lowerWord.split("");
                String makeWord = "";
                for(int i = 0; i < lowerWordArr.length; i++) {
                    if(i == 0) {
                        makeWord += lowerWordArr[i].toUpperCase();
                    } else {
                        makeWord += lowerWordArr[i];
                    }
                }
                answer += prefix+makeWord;
            }
            count++;
        }

        if(s.length() > 0 && " ".equals(s.substring(s.length()-1, s.length()))) {
            answer += " ";
        }

        return answer;
    }
}
