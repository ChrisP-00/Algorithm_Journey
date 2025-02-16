package week011_020.week012.day1210_PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj2167 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int startX, startY, endX, endY;

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(st.nextToken()) - 1;
            startY = Integer.parseInt(st.nextToken()) - 1;
            endX = Integer.parseInt(st.nextToken()) - 1;
            endY = Integer.parseInt(st.nextToken()) - 1;

            int sum = calculateSum(arr, startX, startY, endX, endY);

            System.out.println(sum);
        }
    }

    public static int calculateSum(int[][] arr, int sX, int sY, int eX, int eY) {
        int sum = 0;

        for (int i = sX; i <= eX; i++) {
            for (int j = sY; j <= eY; j++) {
                sum += arr[i][j];
            }
        }

        return sum;
    }
}
