package com.jungjoongi.algorithm.programmers.test;

import java.util.*;
import java.util.stream.Collectors;

public class Skill_Check_06 {
    public static void main(String[] args) {

        System.out.println(solution(new String[][] {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}}));

    }

    public static String[] solution(String[][] tickets) {
        boolean[] isVisit = new boolean[tickets.length];
        List<String> list = new ArrayList<>();
        String[] answer = {};
        dfs("ICN", "ICN", tickets, isVisit, list, 0);
        Collections.sort(list);
        return list.get(0).split(" ");
    }

    public static void dfs(String start, String target, String[][] tickets, boolean[] isVisit, List<String> list, int deps) {

        if(deps == tickets.length) {
            list.add(target);
            return;
        }
        for(int i = 0; i < tickets.length; i++) {
            String next = "";
            if(!isVisit[i] && start.equals(tickets[i][0])) {
                next = tickets[i][1];
                isVisit[i] = true;
                dfs(next, target+ " "+next, tickets, isVisit, list, deps + 1);
                isVisit[i] = false;
            }
        }
    }

}
