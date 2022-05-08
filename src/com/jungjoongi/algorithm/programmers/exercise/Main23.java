package com.jungjoongi.algorithm.programmers.exercise;


import java.util.HashMap;
import java.util.Map;

public class Main23 {

    public static void main(String[] args) {
        solution(6,4,new int[][] {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}});
    }


    /**
     * 2017 카카오코드 예선 카카오프렌즈 컬러링북 LV.2
     * @param m
     * @param n
     * @param picture
     * @return
     */
    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int[] answer = new int[2];

        int x = 0;
        int y = 0;
        Map<String, Point> locate = new HashMap<>();
        Map<Integer, Integer> maxCountMap = new HashMap<>();
        for(int[] arr1 : picture) {
            y = 0;
            for(int arr2 : arr1) {
                Point point = new Point();
                point.setType(arr2);
                locate.put(x+","+y, point);
                y++;
            }
            x++;
        }

        for(int[] arr1 : picture) {
            y = 0;
            for(int arr2 : arr1) {
                Point point = locate.get(x+","+y);
                point.setVisit(true);
                if(x == 0 && y ==0) {
                    maxCountMap.put(arr2, 1);
                    numberOfArea++;
                } else if (x == 0 && y > 0) {
                    Point leftPoint = locate.get(x+","+(y-1));

                } else if (x > 0 && y ==0 ) {

                } else {

                }

                y++;
            }
            x++;
        }



        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        return answer;
    }

}
class Point {
    int type;
    boolean isVisit;

    public int getType() {
        return type;
    }

    public boolean isVisit() {
        return isVisit;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setVisit(boolean visit) {
        isVisit = visit;
    }
}
