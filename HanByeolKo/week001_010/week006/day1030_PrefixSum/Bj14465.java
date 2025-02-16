package week001_010.week006.day1030_PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Bj14465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        HashSet<Integer> broken = new HashSet<Integer>();
        for (int i = 0; i < B; i++) {
            broken.add(Integer.parseInt(br.readLine()));
        }

        int count = 0;

        for (int i = 0; i < K; i++) {
            if (broken.contains(i+1)) {
                count++;
            }
        }

        int min = count;

        for (int i = K; i < N; i++) {
            if (broken.contains(i+1)) {
                count++;
            }
            if(broken.contains(i-K+1)){
                count--;
            }
            min = Math.min(min, count);
        }

        System.out.println(min);
    }
}
