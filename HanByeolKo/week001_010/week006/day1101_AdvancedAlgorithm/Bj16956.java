package week001_010.week006.day1101_AdvancedAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj16956 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        String[] resultMap = new String[row];

        for (int i = 0; i < row; i++) {
            String s = br.readLine();

            if(s.contains("WS") || s.contains("SW")) {
                System.out.println("0");
                return;
            }

            resultMap[i] =  s.replaceAll("\\.","D");
        }

        for (int i = 0; i < row - 1; i++) {
            for (int j = 0; j < col; j++) {
                if (resultMap[i].charAt(j) == 'W' && resultMap[i + 1].charAt(j) == 'S') {
                    System.out.println(0);
                    return;
                }
                if (resultMap[i].charAt(j) == 'S' && resultMap[i + 1].charAt(j) == 'W') {
                    System.out.println(0);
                    return;
                }
            }
        }

        System.out.println(1);
        Arrays.stream(resultMap, 0, row).forEach(System.out::println);
    }
}
