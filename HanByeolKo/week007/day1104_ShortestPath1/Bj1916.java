package week007.day1104_ShortestPath1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj1916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cityCount = Integer.parseInt(br.readLine());
        int busCount = Integer.parseInt(br.readLine());

        List<Map<Integer,Integer>> graph = new ArrayList<>(cityCount + 1);
        for(int i = 0; i <= cityCount; i++) {
            graph.add(new HashMap<>());
        }

        for (int i = 0; i < busCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if(graph.get(from).containsKey(to) && cost > graph.get(from).get(to)) {
                continue;
            }
            graph.get(from).put(to, cost);
        }

        int[] cost = new int[cityCount+1];
        Arrays.fill(cost, Integer.MAX_VALUE);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        cost[start] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()) {
            int current = queue.poll();

            for(int next : graph.get(current).keySet()){
                if(graph.get(current).get(next) + cost[current] < cost[next]) {
                    cost[next] = cost[current] + graph.get(current).get(next);
                    queue.add(next);
                }
            }
        }

        System.out.println(cost[end]);
    }
}
