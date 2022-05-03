package com.jungjoongi.algorithm.note.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class 미로최단거리 {
    public static void main(String[] args) {

        

    }

    public static int solution(int[][] maps) {
        Queue<Node> queue = new LinkedList();
        queue.offer(new Node(0,0, null));
        boolean[][] isVisited = new boolean[maps.length][maps[0].length];
        Node nowPoint = null;
        int[] locateX = {1, -1, 0, 0};
        int[] locateY = {0, 0, -1, 1};
        int xLength = maps.length-1;
        int yLength =  maps[0].length -1;
        isVisited[0][0] = true;

        while (!queue.isEmpty()) {
            nowPoint = queue.poll();
            if(nowPoint.getX() == xLength && nowPoint.getY() == yLength) {
                return nowPoint.getCount();
            }
            for(int i = 0; i < 4; i++) {
                int nextXPoint = nowPoint.getX() + locateX[i];
                int nextYPoint = nowPoint.getY() + locateY[i];

                if(nextXPoint < 0 || nextXPoint > maps.length-1
                        || nextYPoint < 0 || nextYPoint > maps[0].length-1
                        || maps[nextXPoint][nextYPoint] == 0
                        || isVisited[nextXPoint][nextYPoint]) {
                    continue;
                } else {
                    queue.offer(new Node(nextXPoint, nextYPoint, nowPoint));
                    isVisited[nextXPoint][nextYPoint] = true;
                }
            }
        }
        return  -1;
    }
}


class Node {
    private int x;
    private int y;
    private Node root;
    private int count = 1;

    Node(int x, int y, Node root) {
        this.x = x;
        this.y = y;
        this.root = root;

        if(root != null) {
            this.count = root.getCount() + 1;
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
