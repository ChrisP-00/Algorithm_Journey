package week001_010.week008.day1114_BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int brokenQty = Integer.parseInt(br.readLine());

        if(N == 100) {
            System.out.println(0);
            return;
        }

        if(brokenQty == 0) {
            int dif = Math.abs(100 - N);
            String number = String.valueOf(N);
            int result = Math.min(number.length(), dif);

            System.out.println(result);
            return;
        }

        boolean[] broken = new boolean[10];
        String[] nums = br.readLine().split(" ");

        for (int i = 0; i < brokenQty; i++) {
            broken[Integer.parseInt(nums[i])] = true;
        }

        int minPress = getMinPress(N, broken);

        System.out.println(minPress);
    }

    private static int getMinPress(int N, boolean[] broken) {
        int minPress = Math.abs(N - 100);

        for (int i = 0; i <= 1000000; i++) {
            String num = String.valueOf(i);
            boolean isPossible = true;
            for (int j = 0; j < num.length(); j++) {
                if (broken[num.charAt(j) - '0']) {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                minPress = Math.min(minPress, Math.abs(N - i) + String.valueOf(i).length());
            }
        }
        return minPress;
    }
}
