package week001_010.week009.day1122_String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bj5052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCases; i++) {
            int telCount = Integer.parseInt(br.readLine());
            String[] numbers = new String[telCount];
            for (int j = 0; j < telCount; j++) {
                numbers[j] = br.readLine();
            }

            Arrays.sort(numbers);

            boolean flag = true;
            for (int j = 0; j < telCount - 1; j++) {
                if(numbers[j+1].startsWith(numbers[j])) {
                    flag = false;
                    break;
                }
            }

            if(flag) {
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
}
