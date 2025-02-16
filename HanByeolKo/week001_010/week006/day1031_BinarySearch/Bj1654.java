package week001_010.week006.day1031_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj1654 {
    public static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];

        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        long result = binarySearch(arr, N);

        System.out.println(result);
    }

    public static long binarySearch(int[] nums, int target) {
        long left = 1;
        long right  = nums[K-1];

        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;

            for (int num : nums) {
                count += num / mid;
            }

            if (count >= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }
}
