package com.jungjoongi.algorithm.programmers;

import java.util.*;

public class Main16 {

    public static void main(String[] args) {

        solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"});


    }


    /**
     * 카카오 오픈채팅방
     * @param record
     * @return
     */
    public static String[] solution(String[] record) {
        Map<String, String> id = new HashMap<>();
        List<String> list = new ArrayList<>();

        for(String line : record) {

            String[] status = line.split(" ");
            if ("Enter".equals(status[0]) || "Change".equals(status[0])) {
                id.put(status[1], status[2]);
            }
            if ("Enter".equals(status[0])) {
                list.add(status[1]+"|"+"님이 들어왔습니다.");
            } else if ("Leave".equals(status[0])) {
                list.add(status[1]+"|"+"님이 나갔습니다.");
            }
        }

        int count = 0;
        String[] result = new String[list.size()];
        for(String str : list) {
            String msg = id.get(str.split("[|]")[0]) + str.split("[|]")[1];
            result[count] = msg;
            count++;
        }
        return result;
    }

}
