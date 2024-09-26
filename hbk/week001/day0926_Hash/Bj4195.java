package week001.day0926_Hash;

import java.io.*;
import java.util.HashSet;

public class Bj4195 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCases = Integer.parseInt(br.readLine());

        HashSet<String> network = new HashSet<>();
        HashSet<String> history = new HashSet<>();

        int result = 2;

        for (int i = 0; i < testCases; i++) {
            int friends = Integer.parseInt(br.readLine());

            for (int j = 0; j < friends; j++) {
                String temp = br.readLine();

                if (history.contains(temp)) {
                    bw.write(result + "\n");
                    bw.flush();
                    continue;
                }

                history.add(temp);
                // [a,2] [b,2]
                // [c,2] [d,2]

                // [e] [f]
                // [g] [h]
                String[] input = temp.split(" ");

                // [b] [c]
                // [f] [g]
                if (network.contains(input[0]) && network.contains(input[1])) {
                    result += 2;

                } else if (network.contains(input[0]) || network.contains(input[1])) {
                    network.add(input[0]);
                    network.add(input[1]);

                    result++;
                } else {
                    network.add(input[0]);
                    network.add(input[1]);

                }

                bw.write(result + "\n");
                bw.flush();
            }

            network.clear();
            history.clear();
            result = 2;
        }
        bw.close();
    }
}
