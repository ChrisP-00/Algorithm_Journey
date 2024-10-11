package week002.day1001_Sort;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bj1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int meetings = Integer.parseInt(br.readLine());

        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < meetings; i++) {
            String[] input = br.readLine().split(" ");
            list.add(new int[]{Integer.parseInt(input[0]), Integer.parseInt(input[1])});
        }

        list.sort(Comparator.comparingInt((int[]a) -> a[1]).thenComparingInt((int[]a) -> a[0]));

        int count = 0;
        int lastEndTime = 0;

        for (int[] meet : list) {
            if (meet[0] >= lastEndTime) {
                lastEndTime = meet[1];
                count++;
            }
        }

        bw.write(Integer.toString(count));
        bw.flush();
        bw.close();
    }
}
