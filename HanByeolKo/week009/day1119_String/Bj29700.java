package week009.day1119_String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj29700 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int count = 0;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            int relay = 0;

            for(int j = 0; j < M; j++) {
                if(s.charAt(j) == '0') {
                    relay++;
                    if(relay >= K) {
                        count++;
//                        relay = K - 1;
                    }
                }else {
                    relay = 0;
                }
            }
        }

        System.out.println(count);
    }
}
