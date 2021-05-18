package com.jungjoongi.algorithm.hash;

import java.util.*;

public class Hash_01 {
    public static void main(String[] args) {
        Solution s1 = new Solution();
        Solution s2 = new Solution();
        String[] param1 = {"leo", "kiki", "eden"};
        String[] param2 = {"eden", "kiki"};

        System.out.println(s1.solution(param1,param2));
        System.out.println(s2.solution(param1,param2));
    }
}

/**
 * Array의 정렬을 사용해서 값을 비교
 */
class Solution {
    public String solution(String[] participant, String[] completion) {

        Arrays.sort(participant);
        Arrays.sort(completion);
        int i;
        for(i = 0; i < completion.length; i++) {
            if(!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }
        return participant[i];
    }
}

/**
 * Hash를 사용하는 방법
 */
class Solution2 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
        for (String player : completion) hm.put(player, hm.get(player) - 1);

        for (String key : hm.keySet()) {
            if (hm.get(key) != 0){
                answer = key;
            }
        }
        return answer;
    }
}