package com.jungjoongi.algorithm.programmers;


import java.util.Stack;

public class Main27 {

    public static void main(String[] args) {

        System.out.println(solution("baabaa"));
    }

    /**
     * 카카오 문자열 자르기
     * @param s
     * @return
     */
    public static int solution(String s) {
        Stack<String> stack = new Stack<>();
        for(String checkWord : s.split("")) {
            if(stack.isEmpty()) {
                stack.push(checkWord);
            } else {
                if(stack.peek().equals(checkWord)) {
                    stack.pop();
                } else {
                    stack.push(checkWord);
                }
            }
        }

        return stack.size() > 0 ? 0 : 1;
    }

}
