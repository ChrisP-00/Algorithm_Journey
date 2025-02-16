package week001_010.week006.day1101_AdvancedAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj2110 {
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] position = new int[N];

        for (int i = 0; i < N; i++) {
            position[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(position);

        int result = binarySearch(position, C);

        System.out.println(result);

    }

    public static int binarySearch(int[] arr, int target) {
        int left = 1;
        int right = arr[N-1];
        int distance = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            int install = 1;
            int last = arr[0];

            for (int i = 1; i < N; i++) {
                if (arr[i] - last >= mid) {
                    install += 1;
                    last = arr[i];
                }
            }

            if(install >= target) {
                distance = mid;
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return distance;
    }
}
