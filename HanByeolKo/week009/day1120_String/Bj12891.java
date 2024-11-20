package week009.day1120_String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj12891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int strLength = Integer.parseInt(st.nextToken());
        int passLength = Integer.parseInt(st.nextToken());

        String dnaString = br.readLine();

        st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[] count = new int[4];

        for (int i = 0; i < passLength; i++) {
            char c = dnaString.charAt(i);
            if (c == 'A') {
                count[0]++;
            }else if (c == 'C') {
                count[1]++;
            }else if (c == 'G') {
                count[2]++;
            }else if (c == 'T') {
                count[3]++;
            }
        }

        int result = 0;

        if(count[0] >= A && count[1] >= C && count[2] >= G && count[3] >= T) {
            result++;
        }

        for(int i = passLength; i < strLength; i++) {
            char in = dnaString.charAt(i);
            char out = dnaString.charAt(i - passLength);

            if(in == 'A'){
                count[0]++;
            }else if (in == 'C'){
                count[1]++;
            }else if (in == 'G'){
                count[2]++;
            }else if (in == 'T'){
                count[3]++;
            }

            if(out=='A'){
                count[0]--;
            }else if (out=='C'){
                count[1]--;
            }else if (out=='G'){
                count[2]--;
            }else if (out=='T'){
                count[3]--;
            }

            if(count[0] >= A && count[1] >= C && count[2] >= G && count[3] >= T) {
                result++;
            }
        }

        System.out.println(result);
    }

}
