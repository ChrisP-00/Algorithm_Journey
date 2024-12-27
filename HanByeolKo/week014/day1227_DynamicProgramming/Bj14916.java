package week014.day1227_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj14916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 1 || n == 3) {
            System.out.println(-1);
            return;
        }

        int quotient = n / 5;
        int remainder = n % 5;

        switch (remainder) {
            case 0 -> System.out.println(quotient);
            case 1, 4 -> System.out.println(quotient + 2);
            case 2 -> System.out.println(quotient + 1);
            case 3 -> System.out.println(quotient + 3);
        }
    }
}
