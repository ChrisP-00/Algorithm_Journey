package week014.day1224_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for(int i = 0; i < testCase; i++){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            System.out.println(count(k,n));
        }
    }

    private static int count(int k, int n){
        int[][] map = new int[k+1][n+1];

        for(int i = 1; i <= n; i++){
            map[0][i] = i;
        }

        for(int i = 1; i <= k; i++){
            for(int j = 1; j <= n; j++){
                map[i][j] = map[i][j-1] + map[i-1][j];
            }
        }

        return map[k][n];
    }
}
