package com.jungjoongi.algorithm.programmers.exercise;



import java.util.Arrays;

public class Main43 {

    public static void main(String[] args) {
        System.out.println(solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log", "cog"}));

    }
    public static int result = 0;

    /**
     * https://programmers.co.kr/learn/courses/30/lessons/43163
     * 코딩테스트 연습
     * 깊이/너비 우선 탐색(DFS/BFS)
     * 단어 변환
     * @param begin
     * @param target
     * @param words
     * @return
     */
    public static int solution(String begin, String target, String[] words) {
        boolean[] isVisit = new boolean[words.length];
        result = words.length;

        if("".equals(Arrays.stream(words)
                .filter(e -> e.equals(target))
                .findAny()
                .orElse(""))) {
            return 0;
        }
        dfs(begin, target, words, 0, isVisit);
        return result;
    }

    public static boolean isDiffWordSuccess(String t1, String t2) {

        int failCnt = 0;
        for(int i = 0; i < t1.length(); i++) {
            if(t1.charAt(i) != t2.charAt(i)) {
                failCnt++;
            }
        }
        return failCnt == 1 ? true : false;
    }

    public static void dfs(String begin, String target, String[] words, int index, boolean[] isVisit) {
        if(result < index) {
            return;
        }
        if(begin.equals(target)) {
            result = Math.min(index, result);
            return;
        }
        for(int i = 0; i < words.length; i++) {
            if(!isVisit[i] && isDiffWordSuccess(begin, words[i])) {
                isVisit[i] = true;
                dfs(words[i], target, words, index+1, isVisit);
                isVisit[i] = false;
            }
        }
    }
}
