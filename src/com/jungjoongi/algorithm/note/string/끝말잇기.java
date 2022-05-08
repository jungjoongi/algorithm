package com.jungjoongi.algorithm.note.string;


import java.util.*;

public class 끝말잇기 {

    public static void main(String[] args) {

        System.out.println(
                solution(2, new String[] {"land", "dream", "mom", "mom", "ror"})
        );
    }


    public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        List<Word> wordList = new ArrayList<>();
        int playNum = 1;
        int numIndex = n;
        Map<String, Integer> wordMap = new HashMap<>();
        for(int i = 0; i < words.length; i++) {

            Word word = new Word();
            word.setWord(words[i]);
            word.setPlayNum(playNum);
            wordList.add(word);

           if(numIndex / (playNum+1) == 0) {
               playNum = 1;
           } else {
               playNum++;
           }
        }
        numIndex = n;
        int wordNum = 1;
        wordMap.put(words[0], wordMap.getOrDefault(words[0], 0)+1);
        for(int i = 1; i < wordList.size(); i++) {

            String preWord = wordList.get(i-1).getWord();
            String nowWord = wordList.get(i).getWord();
            wordMap.put(words[i], wordMap.getOrDefault(words[i], 0)+1);
            if(preWord.charAt(preWord.length()-1) != nowWord.charAt(0)
            || wordMap.getOrDefault(nowWord, 1) != 1) {
                answer[0] = wordList.get(i).getPlayNum();
                answer[1] = wordNum;
                break;
            }

            if(i == numIndex-1) {
                wordNum++;
                numIndex = numIndex + n;
            }
        }
        System.out.println(answer[0] + " : "+ answer[1]);
        return answer;
    }
}

class Word {
    private String word;
    private int playNum;

    public void setWord(String word) {
        this.word = word;
    }

    public void setPlayNum(int playNum) {
        this.playNum = playNum;
    }

    public String getWord() {
        return word;
    }

    public int getPlayNum() {
        return playNum;
    }
}
