package week007.day1104_ShortestPath1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Bj18352 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cityCount = Integer.parseInt(st.nextToken());
        int pathCount = Integer.parseInt(st.nextToken());
        int baseDistance = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>(cityCount+1);
        for (int i = 0; i <= cityCount; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < pathCount; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph.get(from).add(to);
        }

        int[] distance = new int[cityCount+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for(int next : graph.get(current)) {
                if(distance[next] == Integer.MAX_VALUE) {
                    distance[next] = distance[current] + 1;
                    queue.add(next);
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= cityCount ; i++) {
            if(distance[i] == baseDistance) {
                result.add(i);
            }
        }

        if(result.isEmpty()){
            System.out.println(-1);
            return;
        }

        List<String> convert = result.stream().map(String::valueOf).collect(Collectors.toList());

        String cities = String.join(" ", convert);

        System.out.println(cities);
    }
}
