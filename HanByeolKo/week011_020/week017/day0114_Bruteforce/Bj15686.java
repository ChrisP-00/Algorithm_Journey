package week011_020.week017.day0114_Bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Bj15686 {
    static int minChickenDistance = Integer.MAX_VALUE;
    static int m;
    static List<int[]> selectedChickens, chickens, houses;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][n];
        chickens = new ArrayList<>();
        houses = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    chickens.add(new int[] { i, j });
                } else if (map[i][j] == 1) {
                    houses.add(new int[] { i, j });
                }
            }
        }

        selectedChickens = new ArrayList<>();
        visited = new boolean[chickens.size()];

        generateCombinations(0, 0);

        System.out.println(minChickenDistance);
    }

    private static void generateCombinations(int start, int depth) {
        if (depth == m) {
            int distance = calculateChickenDistance(selectedChickens);
            minChickenDistance = Math.min(minChickenDistance, distance);
            return;
        }

        for (int i = start; i < chickens.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                selectedChickens.add(chickens.get(i));
                generateCombinations(i + 1, depth + 1);
                selectedChickens.remove(selectedChickens.size() - 1);
                visited[i] = false;
            }
        }
    }

    private static int calculateChickenDistance(List<int[]> selectedChickens) {
        int totalDistance = 0;

        for (int[] house : houses) {
            int minDistance = Integer.MAX_VALUE;

            for (int[] chicken : selectedChickens) {
                int distance = Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
                minDistance = Math.min(minDistance, distance);
            }

            totalDistance += minDistance;
        }

        return totalDistance;
    }
}
