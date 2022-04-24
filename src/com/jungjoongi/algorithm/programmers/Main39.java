package com.jungjoongi.algorithm.programmers;


import java.util.*;

public class Main39 {

    public static void main(String[] args) {
        solution("100-200*300-500+20");

    }



    public static long solution(String expression) {


        char[] expressionCharArray = expression.toCharArray();
        List<String> num = new ArrayList<>();
        List<String> operation = new ArrayList<>();
        Queue<String> queue = new LinkedList();

        StringBuilder number = new StringBuilder();
        int count = 0;
        for(char c : expressionCharArray) {
            number.append(c);
            if(c == '+' || c == '-' || c == '*') {
                num.add(number.delete(number.length()-1, number.length()).toString());
                number = new StringBuilder();
                operation.add(Character.toString(c));
            }
            if(count == expressionCharArray.length - 1) {
                num.add(number.toString());
            }
            count++;
        }


        for(int i = 0; i < operation.size(); i++) {
            queue.offer(num.get(i));
            queue.offer(operation.get(i));
        }
        queue.offer(num.get(num.size()-1));

        operation(queue, "*");
        long answer = 0;
        return answer;
    }

    public static int getMax(List<Integer> num, List<String> operation) {

        return 1;
    }

    public static void operation(Queue<String> q, String exp) {
        System.out.println("------");
        q.forEach(System.out::println);
        System.out.println("------");

        for(int n = 0; n < 3; n++) {
            String preTemp = "";
            String temp = "";
            for(int i = 0; i < q.size(); i++) {
                preTemp = q.poll();
                temp = q.poll();
                int num = 0;

                System.out.println("------");
                q.forEach(System.out::println);
                System.out.println("------");

                if(exp.equals(temp)) {
                    if("*".equals(exp)) {
                        num = Integer.parseInt(preTemp) * Integer.parseInt(q.poll());
                    } else if("+".equals(exp)) {
                        num = Integer.parseInt(preTemp) + Integer.parseInt(q.poll());
                    } else if("-".equals(exp)) {
                        num = Integer.parseInt(preTemp) - Integer.parseInt(q.poll());
                    }
                    q.offer(Integer.toString(num));
                } else {
                    q.offer(temp);
                    q.offer(preTemp);

                }
            }
        }



    }
}
