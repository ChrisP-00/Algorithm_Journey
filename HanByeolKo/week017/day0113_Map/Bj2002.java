package week017.day0113_Map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Bj2002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> dae = new HashMap<>();
        String[] young = new String[n];

        for (int i = 0; i < n; i++) {
            dae.put(br.readLine(), i);
        }

        for (int i = 0; i < n; i++) {
            young[i] = br.readLine();
        }

        int count = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (dae.get(young[i]) > dae.get(young[j])) {
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);
    }
}