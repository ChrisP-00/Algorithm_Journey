package week001_010.week010.day1127_Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Bj16437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int island = Integer.parseInt(br.readLine());

        List<Integer>[] graph = new ArrayList[island + 1];
        for (int i = 1; i <= island; i++) {
            graph[i] = new ArrayList<>();
        }

        long[] counts = new long[island + 1];

        for (int i = 2; i <= island; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String type = st.nextToken();
            long count = Long.parseLong(st.nextToken());
            int connect = Integer.parseInt(st.nextToken());

            counts[i] = type.equals("W") ? -count : count;

            graph[connect].add(i);
        }

        System.out.println(dfs(1, graph, counts));

    }

    private static long dfs(int node, List<Integer>[] graph, long[] animalCount) {
        long totalSheep = 0;

        for (int child : graph[node]) {
            totalSheep += dfs(child, graph, animalCount);
        }

        totalSheep += animalCount[node];
        return Math.max(0, totalSheep);
    }
}
