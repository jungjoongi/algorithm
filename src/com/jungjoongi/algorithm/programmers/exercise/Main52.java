package com.jungjoongi.algorithm.programmers.exercise;


import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.stream.Collectors;

public class Main52 {

    public static void main(String[] args) throws ParseException {



        System.out.println(
                solution(new int[] {1, 10, 1, 11}, new String[] {"00:00 1234 IN", "00:02 1234 OUT"})
        );
    }


    public static int[] solution(int[] fees, String[] records) {
        Map<String, ParkingInfo> carMap = new HashMap<>();

        for(int i = 0; i < records.length; i++) {
            String[] record = records[i].split(" ");
            carMap.put(record[1], carMap.getOrDefault(record[1], new ParkingInfo()));
            ParkingInfo parkingInfo = carMap.get(record[1]);
            parkingInfo.setCarNo(record[1]);
            if("IN".equals(record[2])) {
                parkingInfo.setIn(record[0]);
            } else {
                parkingInfo.setOut(record[0]);
                try {
                    parkingInfo.getParkingTime();
                } catch (ParseException e) {}

            }
        }

        List<ParkingInfo> list = new ArrayList<>();
        for(String key : carMap.keySet()) {
            ParkingInfo parkingInfo = carMap.get(key);
            if(!parkingInfo.isOut()) {
                try {
                    parkingInfo.getParkingTime();
                } catch (ParseException e) {}

            }
            list.add(parkingInfo);
            parkingInfo.getTotalCharge(fees);
        }

        return list.stream().sorted((o1, o2) ->  {
            return Integer.parseInt(o1.getCarNo()) - Integer.parseInt(o2.getCarNo());
        }).map(ParkingInfo::getTotalCharge).mapToInt(Integer::intValue).toArray();
    }
}

class ParkingInfo {
    String in;
    String out = "2022030323:59";
    String carNo;
    boolean isOut = false;
    int minuteSum = 0;
    int totalCharge = 0;

    public int getTotalCharge() {
        return totalCharge;
    }

    public String getIn() {
        return in;
    }

    public String getOut() {
        return out;
    }

    public String getCarNo() {
        return carNo;
    }
    public void setIn(String in) {
        this.isOut = false;
        this.in = "20220303"+in;
    }

    public void setOut(String out) {
        this.out = "20220303"+out;
        this.isOut = true;

    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public boolean isOut() {
        return isOut;
    }

    public int getMinuteSum() {
        return minuteSum;
    }

    public void setOut(boolean out) {
        isOut = out;
    }

    public void setMinuteSum(int minuteSum) {
        this.minuteSum = minuteSum;
    }

    public void getParkingTime() throws ParseException {

        String in = this.in;
        String out = this.out;
        this.isOut = true;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHH:mm");
        Date inTime = simpleDateFormat.parse(in);
        Date outTime = simpleDateFormat.parse(out);
        this.in = "";
        this.out = "2022030323:59";
        this.minuteSum += (int)(outTime.getTime() - inTime.getTime()  ) / 60000;
    }

    public int getTotalCharge(int[] fees) {
        // fees[0] 기본시간(분)    ex) 180 분
        // fees[1] 기본요금       ex) 5000 원
        // fees[2] 단위 시간(분)   ex) 10 분
        // fees[3] 단위요금(원)    ex) 600 원

        int parkingTime = this.minuteSum;
        int charge = fees[1]; // 기본요금 우선 부과
        if(parkingTime > fees[0]) { // 단위시간보다 작게 주차 기본요금만 부과
            charge += Math.ceil((parkingTime-fees[0])*1.0 / fees[2]) * fees[3];
        }
        this.totalCharge += charge;
        return this.totalCharge;
    }
}