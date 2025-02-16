package week011_020.week012.day1210_PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj2851 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] mushroom = new int[10];
        int sum = 0;
        int[] total = new int[10];

        for (int i = 0; i < 10; i++) {
            mushroom[i] = Integer.parseInt(br.readLine());
            sum += mushroom[i];
            total[i] = sum;
        }

        int small = 0;
        int large = 0;

        for (int i = 0; i < 10; i++) {
            if (total[i] > 100) {
                large = total[i];
                small = total[i - 1];
                break;
            }
            large = total[i];
        }

        int smallDif = Math.abs(100 - small);
        int largeDif = Math.abs(100 - large);

        int result = smallDif < largeDif ? small : large;

        System.out.println(result);
    }
}
