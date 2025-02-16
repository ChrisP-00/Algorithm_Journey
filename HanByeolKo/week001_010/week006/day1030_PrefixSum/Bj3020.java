package week001_010.week006.day1030_PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj3020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[] down = new int[N/2];
        int[] up = new int[N/2];

        for (int i = 0; i < N / 2; i++) {
            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());
            down[i] = a;
            up[i] = b;
        }

        Arrays.sort(down);
        Arrays.sort(up);

        int min = N;
        int count = 0;

        for (int i = 1; i < H + 1; i++) {
            int conflict = binarySearch(0, N/2, i, down) + binarySearch(0, N/2, H-i+1, up);
            if (min == conflict){
                count++;
                continue;
            }
            if (min > conflict) {
                min = conflict;
                count = 1;
            }
        }
        System.out.println(min + " " + count);
    }

    static int binarySearch(int left, int right, int h, int[] arr) {
        while (left < right) {
            int mid = (left + right) / 2;

            if (arr[mid] >= h) {
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return arr.length - right;
    }
}
