package week001_010.week008.day1115_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int result = Integer.MAX_VALUE;

        for (int fiveCount = 0; fiveCount <= n / 5; fiveCount++) {
            int remain = n - (fiveCount * 5);

            if (remain % 3 == 0) {
                int threeCount = remain / 3;
                result = Math.min(result, fiveCount + threeCount);
            }
        }

        if (result == Integer.MAX_VALUE) {
            result = -1;
        }

        System.out.println(result);
    }
}
