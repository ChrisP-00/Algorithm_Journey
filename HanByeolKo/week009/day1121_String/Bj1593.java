package week009.day1121_String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1593 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int pass = Integer.parseInt(st.nextToken());
        int origin = Integer.parseInt(st.nextToken());

        String passStr = br.readLine();
        String originStr = br.readLine();

        int[] alphabet = new int[52];
        int[] passFreq = new int[52];

        for (char c : passStr.toCharArray()) {
            if (Character.isUpperCase(c)) {
                passFreq[c - 'A']++;
            } else {
                passFreq[c - 'a' + 26]++;
            }
        }

        for (int i = 0; i < pass; i++) {
            char c = originStr.charAt(i);
            if (Character.isUpperCase(c)) {
                alphabet[c - 'A']++;
            } else {
                alphabet[c - 'a' + 26]++;
            }
        }

        int count = 0;

        if (matches(passFreq, alphabet)) {
            count++;
        }

        for (int i = pass; i < origin; i++) {
            char in = originStr.charAt(i);
            char out = originStr.charAt(i - pass);
            if (Character.isUpperCase(in)) {
                alphabet[in - 'A']++;
            } else {
                alphabet[in - 'a' + 26]++;
            }

            if (Character.isUpperCase(out)) {
                alphabet[out - 'A']--;
            } else {
                alphabet[out - 'a' + 26]--;
            }

            if (matches(passFreq, alphabet)) {
                count++;
            }
        }

        System.out.println(count);

    }

    private static boolean matches(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
