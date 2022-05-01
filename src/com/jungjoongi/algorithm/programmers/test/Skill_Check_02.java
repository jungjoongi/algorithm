package com.jungjoongi.algorithm.programmers.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Skill_Check_02 {
    public static void main(String[] args) {

        System.out.println(solution("baabaa"));

    }

    public static int solution(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(!stack.empty() && c == stack.peek()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty() ? 1 : 0;

    }
}
