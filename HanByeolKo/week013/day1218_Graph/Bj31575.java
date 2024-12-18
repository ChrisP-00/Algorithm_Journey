package week013.day1218_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj31575 {
    static int[][] map;
    static boolean[][] visited;
    static int m, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean result = dfs(map, visited, 0, 0, m, n);

        if (result) {
            System.out.println("Yes");
            return;
        }

        System.out.println("No");
    }

    private static boolean dfs(int[][] map, boolean[][] visited, int x, int y, int m, int n) {
        if (x == m - 1 && y == n - 1) {
            return true;
        }

        if (x < 0 || x >= m || y < 0 || y >= n || map[x][y] == 0 || visited[x][y]) {
            return false;
        }

        visited[x][y] = true;

        if (dfs(map, visited, x + 1, y, m, n)) {
            return true;
        }
        if (dfs(map, visited, x, y + 1, m, n)) {
            return true;
        }

        return false;
    }

}
