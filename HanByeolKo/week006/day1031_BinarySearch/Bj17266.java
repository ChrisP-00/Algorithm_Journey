package week006.day1031_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj17266 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] pos = new int[M];
        for (int i = 0; i < M; i++) {
            pos[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(pos);

        int left = 1;
        int right = N;
        int result = N;

        while (left <= right) {
            int mid = (left + right) / 2;

            if(canCoverAll(N, pos, mid)){
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(result);
    }

    public static boolean canCoverAll(int roadLength, int[] positions, int height) {
        if (positions[0] > height) return false;

        for (int i = 1; i < positions.length; i++) {
            int distance = positions[i] - positions[i-1];
            if (distance > 2 * height) return false;
        }

        return (roadLength - positions[positions.length - 1] <= height);
    }
}
