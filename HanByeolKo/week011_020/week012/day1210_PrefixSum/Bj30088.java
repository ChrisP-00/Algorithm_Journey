package week011_020.week012.day1210_PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj30088 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int[] sum = new int[testCase];

        for(int i = 0; i < testCase; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int human = Integer.parseInt(st.nextToken());
            int time = 0;
            for(int j = 0; j < human; j++){
                time += Integer.parseInt(st.nextToken());
            }
            sum[i] = time;
        }

        Arrays.sort(sum);
        int total = 0;
        int[] prefixSum = new int[testCase];

        for(int i = 0; i < testCase; i++){
            total += sum[i];
            prefixSum[i] = total;
        }

        long result = 0;

        for(int i = 0; i < testCase; i++){
            result += prefixSum[i];
            System.out.println(sum[i]);
        }

        System.out.println(result);
    }
}