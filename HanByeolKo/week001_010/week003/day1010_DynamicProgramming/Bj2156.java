package week001_010.week003.day1010_DynamicProgramming;

import java.io.*;

public class Bj2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int glass = Integer.parseInt(br.readLine()) + 1;
        int[] amount = new int[glass];
        int[] dp = new int[glass];

        for (int i = 1; i < glass; i++) {
            amount[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = amount[1];

        if (glass > 2) {
            dp[2] = amount[1] + amount[2];
        }

        for (int i = 3; i < glass; i++) {
            dp[i] = Math.max(dp[i - 2] + amount[i],
                    Math.max(dp[i - 3] + amount[i-1] + amount[i], dp[i - 1]));
        }

        bw.write(String.valueOf(dp[glass - 1]));
        bw.flush();
        bw.close();
    }
}
