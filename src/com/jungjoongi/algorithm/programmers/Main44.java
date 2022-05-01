package com.jungjoongi.algorithm.programmers;



import java.util.*;
import java.util.stream.Collectors;

public class Main44 {

    public static void main(String[] args) {

        System.out.println(solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}}));
    }

    /**
     * https://programmers.co.kr/learn/courses/30/lessons/43164
     * 코딩테스트 연습
     * 깊이/너비 우선 탐색(DFS/BFS)
     * 여행경로
     * @param tickets
     * @return
     */
    public static String[] solution(String[][] tickets) {

        boolean[] isVisit = new boolean[tickets.length];
        List<String> result = new ArrayList<>();
        dfs(tickets, "ICN", "ICN", 0, result, isVisit);
        Collections.sort(result);
        return result.get(0).split(" ");


    }
    public static void dfs(String[][] tickets, String start, String sum, int deps, List<String> result, boolean[] isVisit) {

        if(deps == tickets.length) {
            result.add(sum);
            return;
        }
        for(int i = 0; i < tickets.length; i++) {
            String next = "";
            if(tickets[i][0].equals(start) && !isVisit[i]) {
                next = tickets[i][1];
                isVisit[i] = true;
                dfs(tickets, next, sum + " " + next, deps + 1, result, isVisit);
                isVisit[i] = false;
            }
        }
    }


}
