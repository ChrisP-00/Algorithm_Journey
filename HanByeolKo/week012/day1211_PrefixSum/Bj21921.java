package week012.day1211_PrefixSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] visitors = new int[n];

        st = new StringTokenizer(br.readLine());

        int sum = 0;
        int max = 0;
        int same = 1;

        for(int i = 0; i < n; i++){
            visitors[i] = Integer.parseInt(st.nextToken());
            sum += visitors[i];
            if(i >= x - 1){
                if(max <= sum){
                    if(max < sum){
                        same = 1;
                    }

                    if(max == sum){
                        same++;
                    }
                    max = sum;
                }
                sum -= visitors[i - x + 1];
            }
        }

        if(sum == 0){
            System.out.println("SAD");
            return;
        }

        System.out.println(max);
        System.out.println(same);
    }
}
