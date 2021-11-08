package com.jungjoongi.algorithm.programmers;

public class Main4 {

    public static void main(String[] args) {
        String p = "PM 11:12:50";
        int n = 36000;
        String[] timeSplit = p.split(" ");
        String[] timeMinuteSecondArr = timeSplit[1].split(":");
        String timeStr = timeMinuteSecondArr[0];
        String minuteStr = timeMinuteSecondArr[1];
        String secondStr = timeMinuteSecondArr[2];
        int time = Integer.parseInt(timeStr);
        int minute = Integer.parseInt(minuteStr);
        int second = Integer.parseInt(secondStr);
        second =  second + n;
        int reminder = 0;
        StringBuilder sb = new StringBuilder();

        if(second >= 60) {
            reminder = second / 60;
            second = second % 60;
            minute = reminder + minute;
        }
        if(minute >= 60) {
            reminder = minute / 60;
            minute = minute % 60;
            time = reminder + time;
        }
        if("PM".equals(timeSplit[0])) {
            time = time + 12;
            System.out.println(";;"+time);
            time = time >= 24 ? time%24 : time;
        } else {
            time = time >= 24 ? time%24 : time;
        }
        secondStr = second < 10 ? "0"+Integer.toString(second) : Integer.toString(second);
        minuteStr = minute < 10 ? "0"+Integer.toString(minute) : Integer.toString(minute);
        timeStr = time < 10 ? "0"+Integer.toString(time) : Integer.toString(time);


        System.out.println(sb.append(timeStr).append(":").append(minuteStr).append(":").append(secondStr).toString());

        System.out.println(27%24);
    }
}
