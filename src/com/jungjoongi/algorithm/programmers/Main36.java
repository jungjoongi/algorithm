package com.jungjoongi.algorithm.programmers;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main36 {

    public static void main(String[] args) {
        System.out.println(solution("KAKAO"));
    }



    public static int[] solution(String msg) {

        Map<String, Integer> keyMap = new HashMap<>();

        keyMap.put("A", 1);
        keyMap.put("B", 2);
        keyMap.put("C", 3);
        keyMap.put("D", 4);
        keyMap.put("E", 5);
        keyMap.put("F", 6);
        keyMap.put("G", 7);
        keyMap.put("H", 8);
        keyMap.put("I", 9);
        keyMap.put("J", 10);
        keyMap.put("K", 11);
        keyMap.put("L", 12);
        keyMap.put("M", 13);
        keyMap.put("N", 14);
        keyMap.put("O", 15);
        keyMap.put("P", 16);
        keyMap.put("Q", 17);
        keyMap.put("R", 18);
        keyMap.put("S", 19);
        keyMap.put("T", 20);
        keyMap.put("U", 21);
        keyMap.put("V", 22);
        keyMap.put("W", 23);
        keyMap.put("X", 24);
        keyMap.put("Y", 25);
        keyMap.put("Z", 26);
        int maxindex = 26;
        int maxWordLength = 1;
        String[] words = msg.split("");
        List<Integer> resultList = new ArrayList<>();

        A:for(int i = 0; i < words.length; i++) {
            String searchWord = "";
            int dicIndex = 0;
            int searchIndex = 0;
            B:for(int j = 0; j < maxWordLength; j++) {
                //사전에 등록된 글자 수 만큼 next 스캔
                if(i+j >= words.length) { // 스캔 인덱스가 초과하면 break;
                    break B;
                }
                searchWord += words[i+j]; // 스캔 단어 (K + A)
                int index = keyMap.get(searchWord); // 등록된 단어 있는지 조회
                if(index != 0) {

                    dicIndex = i+j;
                    searchIndex = index;

                    System.out.println("진입" + searchWord +" : " + dicIndex + " : " + searchIndex);
                }
            }

            if(searchIndex > 26) {

                String makeWord = msg.substring(i, dicIndex);
                keyMap.put(makeWord, ++maxindex);
                maxWordLength = makeWord.length() > maxWordLength ? makeWord.length() : maxWordLength;

            } else {
                resultList.add(searchIndex);
                if(i < words.length -1) {
                    keyMap.put(words[i+1], ++maxindex);
                    maxWordLength = words[i+1].length() > maxWordLength ? words[i+1].length() : maxWordLength;
                }
            }
        }
        resultList.stream().forEach(System.out::println);
        return resultList.stream().mapToInt(i -> i).toArray();
    }
}
