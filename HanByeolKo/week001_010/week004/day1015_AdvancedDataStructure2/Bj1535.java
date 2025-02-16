package week001_010.week004.day1015_AdvancedDataStructure2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bj1535 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {

        int person = Integer.parseInt(readLine());
        int[][] dp = new int[person][100];

        int[] damage = Arrays.stream(readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] joy = Arrays.stream(readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 배낭 무게 == 체력
        // 물건 무게 == 데미지
        // 가치 == 기쁨

        // 데미지 > 체력
        // dp[d][h] = dp[d-1][h]

        // 데미지 <= 체력
        // dp[d][h] = max(dp[d-1][h], 현재기쁨 + dp[d-1][h-현재데미지])

        for (int h = 0; h < 100; h++) {
            if (damage[0] <= h) {
                dp[0][h] = joy[0];
            }
        }

        for (int d = 1; d < person; d++) {
            for (int h = 0; h < 100; h++) {
                if (damage[d] > h) {
                    dp[d][h] = dp[d - 1][h];
                } else {
                    dp[d][h] = Math.max(dp[d - 1][h], joy[d] + dp[d - 1][h - damage[d]]);
                }
            }
        }

        System.out.println(dp[person - 1][99]);

    }

    private static String readLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
