package week011_020.week012.day1212_SlidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj12847 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] money = new int[n];
        long sum = 0L;
        long max = 0L;

        for(int i = 0; i < n; i++){
            money[i] = Integer.parseInt(st.nextToken());
            sum += money[i];

            if(i >= m){
                sum -= money[i - m];
            }

            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
