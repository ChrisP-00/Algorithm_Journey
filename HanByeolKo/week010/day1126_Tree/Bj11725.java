package week010.day1126_Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Bj11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
            map.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
        }

        Map<Integer, Integer> parents = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(1);
        visited.add(1);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (Integer next : map.get(current)) {
                if (!visited.contains(next)) {
                    parents.put(next, current);
                    queue.add(next);
                    visited.add(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 2; i <= n; i++) {
            sb.append(parents.get(i)).append("\n");
        }

        System.out.print(sb);
    }
}
