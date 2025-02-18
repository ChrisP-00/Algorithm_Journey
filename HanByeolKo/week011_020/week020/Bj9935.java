package week011_020.week020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            sb.append(c);

            if (sb.length() >= bomb.length()) {
                boolean match = true;
                for (int i = 0; i < bomb.length(); i++) {
                    if (sb.charAt(sb.length() - bomb.length() + i) != bomb.charAt(i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    sb.setLength(sb.length() - bomb.length());
                }
            }
        }

        System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
    }
}
