package week010.day1129_TestBank;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pr92341 {
    public int[] solution(int[] fees, String[] records) throws Exception{
        Map<String, List<String[]>> record = splitRecords(records);
        Map<String, Integer> totalTimes = calculateTotalParkingTime(record);
        Map<String, Integer> parkingFee = totalCarsFee(totalTimes, fees);

        List<String> sortedCars = new ArrayList<>(parkingFee.keySet());
        Collections.sort(sortedCars);

        int[] answer = new int[sortedCars.size()];
        for (int i = 0; i < sortedCars.size(); i++) {
            answer[i] = parkingFee.get(sortedCars.get(i));
        }

        return answer;
    }

    public static  Map<String, Integer> calculateTotalParkingTime(Map<String, List<String[]>> record){
        Map<String, Integer> parkingTime = new HashMap<>();

        for (String carNumber : record.keySet()) {
            List<String[]> logs = record.get(carNumber);
            int totalTime = 0;
            String lastInTime = null;

            for (String[] log : logs) {
                String time = log[0];
                String status = log[1];

                if (status.equals("IN")) {
                    lastInTime = time;
                } else if (status.equals("OUT")) {
                    totalTime += calculateParkingTime(lastInTime, time);
                    lastInTime = null;
                }
            }

            if (lastInTime != null) {
                totalTime += calculateParkingTime(lastInTime, "23:59");
            }

            parkingTime.put(carNumber, totalTime);
        }

        return parkingTime;
    }

    public static Map<String, Integer> totalCarsFee(Map<String, Integer> totalTimes, int[] fees){
        Map<String, Integer> map = new HashMap<>();
        for(String carNumber : totalTimes.keySet()){
            int totalTime = totalTimes.get(carNumber);
            int fee = calculateFee(totalTime, fees[0], fees[1], fees[2], fees[3]);
            map.put(carNumber, fee);
        }
        return map;
    }

    public static Map<String, List<String[]>> splitRecords(String[] records){
        Map<String, List<String[]>> recordMap = new HashMap<>();
        for(String data : records){
            String[] temp = data.split(" ");
            String time = temp[0];
            String carNumber = temp[1];
            String status = temp[2];

            recordMap.computeIfAbsent(carNumber, k -> new ArrayList<>()).add(new String[]{time,status});
        }

        return recordMap;
    }

    public static int calculateParkingTime(String inTime, String outTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime in = LocalTime.parse(inTime, formatter);
        LocalTime out = LocalTime.parse(outTime, formatter);

        return (int) ChronoUnit.MINUTES.between(in,out);
    }

    public static int calculateFee(int totalTime, int defaultMinute, int defaultFee, int unitMinute, int unitFee){
        if(totalTime <= defaultMinute){
            return defaultFee;
        }
        int extra = totalTime - defaultMinute;
        return defaultFee + (int) Math.ceil((double) extra/unitMinute) * unitFee;
    }
}
