package com.jungjoongi.algorithm.programmers;

import java.util.*;
import java.util.stream.Stream;

public class Main17 {

    public static void main(String[] args) {

        solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}, 2);


    }


    /**
     *  [카카오] 신고결과 받기
     * @param id_list
     * @param report
     * @param k
     * @return
     */
    public static int[] solution(String[] id_list, String[] report, int k) {

        Map<String, Users> userMap = new LinkedHashMap<>();
        for(String id : id_list) {
            userMap.put(id, new Users());
        }

        for(String reportInfo : report) {
            String myId = reportInfo.split(" ")[0];
            String targetId = reportInfo.split(" ")[1];
            if(!userMap.get(myId).getTargetReportId().contains(targetId)) {
                userMap.get(targetId).setReportCount(userMap.get(targetId).getReportCount()+1);
            }
            userMap.get(myId).getTargetReportId().add(targetId);
        }

        int[] result = new int[userMap.size()];
        int count = 0;
        for(String key : userMap.keySet()) {
            for(String target : userMap.get(key).getTargetReportId()) {
                result[count] = userMap.get(target).getReportCount() >= k ? result[count] +1 : result[count];
            }
            count++;
        }
        return result;

    }



}

class Users {
    int reportCount;
    Set<String> targetReportId;

    public int getReportCount() {
        return reportCount;
    }

    public Set<String> getTargetReportId() {
        if(targetReportId == null) {
            targetReportId = new HashSet<>();
        }
        return this.targetReportId;
    }

    public void setReportCount(int reportCount) {
        this.reportCount = reportCount;
    }
}

