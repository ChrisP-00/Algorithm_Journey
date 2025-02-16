package week001_010.week003.day1009_Greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Bj1092 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cranes = Integer.parseInt(br.readLine());
        List<Integer> capacity = new ArrayList<>(Stream.of(br.readLine().split(" "))
                .map(Integer::parseInt)
                .sorted(Comparator.reverseOrder())
                .toList());
        int boxes = Integer.parseInt(br.readLine());
        List<Integer> weights = new ArrayList<>(Stream.of(br.readLine().split(" "))
                .map(Integer::parseInt)
                .sorted(Comparator.reverseOrder())
                .toList());

        if (capacity.get(0) < weights.get(0)) {
            bw.write("-1");
            bw.flush();
            bw.close();
            return;
        }

        for (int i = 0; i < capacity.size(); i++) {
            if (capacity.get(i) < weights.get(boxes - 1)) {
                capacity.remove(i);
            }
        }

        int count = 0;

        while (!weights.isEmpty()) {
            for (int i = 0; i < capacity.size(); i++) {
                for (int j = 0; j < weights.size(); j++) {
                    if (capacity.get(i) >= weights.get(j)) {
                        weights.remove(j);
                        break;
                    }
                }
            }
            count++;
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
