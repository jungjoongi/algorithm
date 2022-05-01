package com.jungjoongi.algorithm.programmers;


import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

public class Main46 {

    public static void main(String[] args) {

        System.out.println(solution(new String[] {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"}, new String[] {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"}));
    }


    /**
     * 스킬 체크 테스트 Level.2
     * #이진검색 #이분탐색 #dfs
     * @param info
     * @param query
     * @return
     */
    public static int[] solution(String[] info, String[] query) {

        Map<String,List<Integer>> infoMap = new HashMap<>();
        int[] result = new int[query.length];

        for(String line : info) {
            String[] lineArray = line.split(" ");
            dfs("", 0, lineArray, infoMap);
        }

        for(List<Integer> list : infoMap.values()) {
            Collections.sort(list);
        }
        int index = 0;
        for(String queryLine : query) {
            queryLine = queryLine.replaceAll(" and ", "");
            String[] queryArray = queryLine.split(" ");
            List<Integer> searchResult = infoMap.get(queryArray[0]);
            if(searchResult != null) {
                result[index++] = binarySearch(searchResult, Integer.parseInt(queryArray[1]));
            } else {
                result[index++] = 0;
            }
        }
        return result;

    }

    public static void dfs(String objToStr, int deps, String[] lineArray, Map<String,List<Integer>> infoMap) {

        if(deps == 4) {
            List<Integer> dataList = infoMap.get(objToStr);
            if(dataList == null) {
                dataList = new ArrayList<>();
                dataList.add(Integer.parseInt(lineArray[4]));
                infoMap.put(objToStr, dataList);
            } else {
                dataList.add(Integer.parseInt(lineArray[4]));
            }
            return;
        }

        dfs(objToStr + "-", deps+1, lineArray, infoMap);
        dfs(objToStr + lineArray[deps], deps+1, lineArray, infoMap);
    }

    public static int binarySearch(List<Integer> searchResult, int score) {

        int start = 0;
        int end = searchResult.size() - 1;

        while (start <= end) {

            int mid = (start + end) / 2;
            if(score > searchResult.get(mid)) {
                start = mid + 1;
            } else {
                end = mid -1;
            }
        }
        return searchResult.size() - start;
    }

}
