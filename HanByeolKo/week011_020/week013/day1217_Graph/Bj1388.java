package week011_020.week013.day1217_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1388 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] wood = new char[n + 1][m + 1];

        int count = 0;

        for (int i = 1; i <= n; i++) {
            String input = br.readLine();
            for (int j = 1; j <= m; j++) {
                wood[i][j] = input.charAt(j - 1);

                if ((wood[i][j] == '-' && wood[i][j - 1] == '-') || (wood[i][j] == '|' && wood[i - 1][j] == '|')) {
                    continue;
                }

                count++;
            }
        }

        System.out.println(count);
    }
}
