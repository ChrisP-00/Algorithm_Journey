package week012.day1209_PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj21758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] prefixSum = new int[n];
        prefixSum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        int maxHoney = 0;

        for (int i = 1; i < n - 1; i++) {
            int beeA = prefixSum[n - 1] - arr[0] - arr[i];
            int beeB = prefixSum[n - 1] - prefixSum[i];

            int totalHoney = beeA + beeB;

            maxHoney = Math.max(maxHoney, totalHoney);
        }

        for (int i = 1; i < n - 1; i++) {
            int beeA = prefixSum[n - 1] - arr[n - 1] - arr[i];
            int beeB = prefixSum[i - 1];
            int totalHoney = beeA + beeB;
            maxHoney = Math.max(maxHoney, totalHoney);
        }

        for (int i = 1; i < n - 1; i++) {
            int totalHoney = prefixSum[i] - prefixSum[0] + prefixSum[n - 2] - prefixSum[i - 1];
            maxHoney = Math.max(maxHoney, totalHoney);
        }

        System.out.println(maxHoney);
    }
}
