package week011_020.week015.day1230_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj2579 {
    static int[] scoreArr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int step = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;

        scoreArr = new int[step];
        dp = new int[step];

        for (int i = 0; i < step; i++) {
            scoreArr[i] = Integer.parseInt(br.readLine());
        }

        if (step == 1) {
            System.out.println(scoreArr[0]);
            return;
        }

        dp[0] = scoreArr[0];
        dp[1] = scoreArr[0] + scoreArr[1];

        if (step > 2) {
            dp[2] = Math.max(scoreArr[0] + scoreArr[2], scoreArr[1] + scoreArr[2]);
        }

        for (int i = 3; i < step; i++) {
            dp[i] = Math.max(dp[i - 2] + scoreArr[i], dp[i - 3] + scoreArr[i - 1] + scoreArr[i]);
        }

        System.out.println(dp[step - 1]);
    }
}
