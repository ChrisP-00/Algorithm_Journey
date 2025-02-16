package week001_010.week003.day1007_BinarySearch;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bj1939 {
    static List<int[]>[] graph;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] info = br.readLine().split(" ");

        N = Integer.parseInt(info[0]);
        M = Integer.parseInt(info[1]);

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        int minWeight = Integer.MAX_VALUE;
        int maxWeight = Integer.MIN_VALUE;

        for (int i = 0; i < M; i++) {
            String[] bridgeInfo = br.readLine().split(" ");
            int start = Integer.parseInt(bridgeInfo[0]);
            int end = Integer.parseInt(bridgeInfo[1]);
            int weight = Integer.parseInt(bridgeInfo[2]);

            graph[start].add(new int[]{end, weight});
            graph[end].add(new int[]{start, weight});

            minWeight = Math.min(minWeight, weight);
            maxWeight = Math.max(maxWeight, weight);
        }

        String[] routeInfo = br.readLine().split(" ");
        int start = Integer.parseInt(routeInfo[0]);
        int end = Integer.parseInt(routeInfo[1]);

        bw.write(binarySearch(start, end, minWeight, maxWeight) + "");
        bw.flush();
        bw.close();
    }

    static int binarySearch(int start, int end, int minWeight, int maxWeight) {
        int result = minWeight;

        while (minWeight <= maxWeight) {
            int mid = (minWeight + maxWeight) / 2;
            if (bfs(start, end, mid)) {
                result = mid;
                minWeight = mid + 1;
            } else {
                maxWeight = mid - 1;
            }
        }
        return result;
    }

    static boolean bfs(int start, int end, int weight) {
        boolean[] visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (node == end) {
                return true;
            }

            for (int[] next : graph[node]) {

                int nextNode = next[0];
                int nextWeight = next[1];

                if (!visited[nextNode] && nextWeight >= weight) {
                    queue.offer(nextNode);
                    visited[nextNode] = true;
                }

            }
        }

        return false;
    }
}
