package week011_020.week014.day1226_DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj9655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int winner = n % 2;

        if (winner == 1) {
            System.out.println("SK");
            return;
        }

        System.out.println("CY");
    }
}
