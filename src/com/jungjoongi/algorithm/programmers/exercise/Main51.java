package com.jungjoongi.algorithm.programmers.exercise;


import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Main51 {

    public static void main(String[] args) {

        System.out.println(
                solution("{{4,2,3},{3},{2,3,4,1},{2,3}}")
        );
    }


    public static int[] solution(String s) {
        String[] arraySet = s.split("},\\{");
        return Arrays.stream(Arrays.stream(arraySet)
                .map(o -> o.replaceAll("\\{", "").replaceAll("}", ""))
                .sorted((o1, o2) ->  o1.length() - o2.length())
                .reduce((o1, o2) -> {
                    String[] o1Array = o1.split(",");
                    Set<String> set = Arrays.stream(o2.split(",")).collect(Collectors.toSet());
                    String[] returnArray = new String[o1Array.length+1];
                    for(int i = 0; i <= o1Array.length; i++) {
                        if(i == o1Array.length ) {
                            String a = set.iterator().next();
                            returnArray[i] = a;
                            break;
                        } else {
                            returnArray[i] = o1Array[i];
                        }
                        if(set.contains(o1Array[i])) {
                            set.remove(o1Array[i]);
                        }
                    }
                    String rStr = "";
                    for(int i = 0; i < returnArray.length; i++) {
                        if(i == returnArray.length-1) {
                            rStr += returnArray[i];
                        } else {
                            rStr += returnArray[i]+",";
                        }
                    }
                    return rStr;
                })
                .get()
                .split(","))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
    }
}
