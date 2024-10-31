package week006.day1031_BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] sang = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sang[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sang);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int card = Integer.parseInt(st.nextToken());
            if(binarySearch(sang,card)){
                sb.append(1).append(" ");
            }else{
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb);

    }

    public static boolean binarySearch(int[] sang, int card) {
        int left = 0;
        int right = sang.length - 1;

        while (left <= right) {
            int mid = (left+right) / 2;

            if (sang[mid] == card) {
                return true;
            }else if (sang[mid] < card) {
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return false;

    }
}
