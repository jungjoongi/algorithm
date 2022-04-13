package com.jungjoongi.algorithm.programmers;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Main21 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*int a = sc.nextInt();
        int b = sc.nextInt();*/

        int a = 2;
        int b = 2;
        String width = "";
        String print = "";
        for(int i = 0; i < a; i++) {
            width += "*";
        }
        for(int i = 0; i < b; i++) {

            if(i == b-1) {
                print += width;
            } else {
                print += width+"\n";
            }

        }
        System.out.println(print);
    }

}
