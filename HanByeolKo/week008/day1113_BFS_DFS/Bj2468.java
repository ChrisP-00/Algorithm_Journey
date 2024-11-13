package week008.day1113_BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj2468 {
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];

        for (int y = 0; y < n; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int x = 0; x < n; x++) {
                map[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        int maxHeight = 0;

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (map[x][y] > maxHeight) {
                    maxHeight = map[x][y];
                }
            }
        }

        int maxSafeAreaCount = 0;
        for (int h = 0; h < maxHeight; h++) {
            boolean[][] visited = new boolean[n][n];
            int safeAreaCount = 0;

            for (int y = 0; y < n; y++) {
                for (int x = 0; x < n; x++) {
                    if (map[x][y] > h && !visited[x][y]) {
                        dfs(x, y, h, visited, map);
                        safeAreaCount++;
                    }
                }
            }

            maxSafeAreaCount = Math.max(maxSafeAreaCount, safeAreaCount);
        }
        System.out.println(maxSafeAreaCount);
    }

    public static void dfs(int x, int y, int h, boolean[][] visited, int[][] map) {
        visited[x][y] = true;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && map[nx][ny] > h) {
                dfs(nx, ny, h, visited, map);
            }
        }
    }
}
