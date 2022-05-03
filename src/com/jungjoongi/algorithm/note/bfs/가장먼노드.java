package com.jungjoongi.algorithm.note.bfs;

import java.util.*;

public class 가장먼노드 {
    public static void main(String[] args) {

        solution(6, new int[][] {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}});

    }

    public static int solution(int n, int[][] edge) {

        Set<Integer> set = new HashSet<>();
        for(int[] edgeY : edge) {
            for(int edgeX : edgeY) {
                set.add(edgeX);
            }
        }
        Graph graph = new Graph(set);
        for(int i = 0; i < edge.length; i++) {
            graph.addEdge(edge[i][0], edge[i][1]);
        }
        graph.bfs(1);

        return graph.map.get(graph.max);
    }

}

class Graph {
    class Node3 {
        int data;
        int count = 1;
        LinkedList<Node3> adjacent;
        boolean marked;
        Node3(int data) {
            this.data = data;
            this.marked = false;
            adjacent = new LinkedList<>();
        }
    }
    Node3[] nodes;
    int max = 0;
    Map<Integer, Integer> map = new HashMap<>();

    Graph(Set<Integer> set) {
        nodes = new Node3[set.size()];
        int index = 0;
        for(int s : set) {
            nodes[index++] = new Node3(s);
        }
    }

    void bfs(int start) {
        int index = 0;
        for(int i = 0; i < nodes.length; i++) {
            if(nodes[i].data == start) {
                index = i;
                break;
            }
        }
        Node3 root = nodes[index];
        Queue<Node3> queue = new LinkedList<>();
        queue.offer(root);
        root.marked = true;

        while (!queue.isEmpty()) {
            Node3 r = queue.poll();

            for(Node3 n : r.adjacent) {
                if(!n.marked) {
                    n.marked = true;
                    n.count = r.count + 1;
                    queue.offer(n);
                }
            }
            map.put(r.count, map.getOrDefault(r.count, 0)+1);
            max = Math.max(max, r.count);
        }
    }

    void addEdge(int i1, int i2) {
        int i1Index = -1;
        int i2Index = -1;
        for(int i = 0; i < nodes.length; i++) {
            if(nodes[i].data == i1) {
                i1Index = i;
            } else if(nodes[i].data == i2) {
                i2Index = i;
            }
            if(i1Index > -1 && i2Index > -1) {
                break;
            }
        }
        Node3 n1 = nodes[i1Index];
        Node3 n2 = nodes[i2Index];

        if(!n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
        }
        if(!n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1);
        }
    }
}



