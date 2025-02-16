package week001_010.week002.day1002_Graph;

import java.io.*;

public class Bj9372 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());
        String dump;

        for (int i = 0; i < testCase; i++) {
            String[] arr = br.readLine().split(" ");
            int country = Integer.parseInt(arr[0]);
            int aircraft = Integer.parseInt(arr[1]);

            bw.write(country-1 + "\n");

            for (int j = 0; j < aircraft; j++) {
                dump = br.readLine();
            }
            bw.flush();
        }
        bw.close();
    }
}
