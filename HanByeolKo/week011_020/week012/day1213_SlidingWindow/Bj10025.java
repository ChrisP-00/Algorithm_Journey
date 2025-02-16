package week011_020.week012.day1213_SlidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj10025 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int range = 2 * k + 1;

        int[] ice = new int[1000000];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            ice[x] += g;
        }

        int sum = 0;
        for (int i = 0; i <= range && i < 1000000; i++) {
            sum += ice[i];
        }

        int max = sum;

        for (int i = range + 1; i < 1000000; i++) {
            sum += ice[i];
            sum -= ice[i - range - 1];
            max = Math.max(sum, max);
        }

        System.out.println(max);
    }
}
