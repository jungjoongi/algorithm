package com.jungjoongi.algorithm.note.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 컬러링영역 {
    public static void main(String[] args) {

        solution(6,4,new int[][] {{1, 1, 1, 0}, {1, 1, 1, 0}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 1}});

    }



    public static int[] solution(int m, int n, int[][] picture) {
        boolean[][] isVisited = new boolean[picture.length][picture[0].length];
        int[] answer = new int[2];
        int maxCount = 0;
        int groupCount = 0;
        for(int y = 0; y < picture.length; y++) {
            for(int x = 0; x < picture[y].length; x++) {
                if(picture[y][x] == 0 || isVisited[y][x]) {
                    continue;
                }

                Stack<Node2> stack = new Stack<>();
                isVisited[y][x] = true;
                stack.push(new Node2(y, x, null));
                maxCount = Math.max(bfs(isVisited, picture, stack), maxCount);
                groupCount++;
            }
        }
        System.out.println(groupCount + " : "+maxCount);
        answer[0] = groupCount;
        answer[1] = maxCount;
        return answer;

    }

    public static int bfs(boolean[][] isVisited, int[][] picture, Stack<Node2> stack) {
        Node2 nowPoint = null;
        int[] locateX = {1, -1, 0, 0};
        int[] locateY = {0, 0, -1, 1};
        int localCount = 0;

        while (!stack.isEmpty()) {
            nowPoint = stack.pop();
            localCount++;
            for(int i = 0; i < 4; i++) {
                int nextXPoint = nowPoint.getX() + locateX[i];
                int nextYPoint = nowPoint.getY() + locateY[i];

                if(nextXPoint < 0 // 왼쪽좌표 over
                || nextXPoint > picture[0].length-1 // 오른쪽좌표 over
                || nextYPoint < 0  // 위쪽좌표 over
                || nextYPoint > picture.length-1 ) {// 아래좌표 over
                    continue;
                } else if(!isVisited[nextYPoint][nextXPoint] && picture[nextYPoint][nextXPoint] == picture[nowPoint.getY()][nowPoint.getX()]) {
                    stack.push(new Node2(nextYPoint, nextXPoint, nowPoint));
                    isVisited[nextYPoint][nextXPoint] = true;
                }
            }
        }
        return localCount;
    }
}

class Node2 {
    private int x;
    private int y;
    private Node2 root;
    private int count = 0;

    Node2(int y, int x, Node2 root) {
        this.x = x;
        this.y = y;
        this.root = root;

        if(root != null) {
            this.count = root.getCount()+1;
        } else {
            this.count = 1;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getCount() {
        return count;
    }
}

