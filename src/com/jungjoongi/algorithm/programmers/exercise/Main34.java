package com.jungjoongi.algorithm.programmers.exercise;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main34 {

    public static void main(String[] args) {
        System.out.println(solution(new String[] {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"}));
    }



    public static String[] solution(String[] record) {
        Map<String, String> id = new HashMap<>();
        List<String> chatList = new ArrayList<>();
        for(String row : record) {
            String[] status = row.split(" ");
            if(status.length > 2) {
                id.put(status[1], status[2]);
                if("Enter".equals(status[0])) {
                    chatList.add(status[1]+"님이 들어왔습니다.");
                }
            } else {
                chatList.add(status[1]+"님이 나갔습니다.");
            }
        }
        return chatList.stream().map(s -> {
            String[] arr = s.split("님이");
            String i = arr[0];
            return id.get(i)+"님이"+arr[1];
        }).toArray(String[]::new);

    }
}
