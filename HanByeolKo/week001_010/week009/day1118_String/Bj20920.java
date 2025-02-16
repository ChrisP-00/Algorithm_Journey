package week001_010.week009.day1118_String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Bj20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<String> wordList = new ArrayList<String>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() < M) {
                continue;
            }
            wordList.add(word);
        }

        Map<String, Long> map = wordList.stream()
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));

        map.entrySet().stream().sorted(Comparator.comparing(Map.Entry<String, Long>::getValue).reversed()
                        .thenComparing(entry -> entry.getKey().length(), Comparator.reverseOrder())
                        .thenComparing(Map.Entry::getKey))
                .forEach(entry -> sb.append(entry.getKey()).append("\n"));

        System.out.println(sb);

    }
}
