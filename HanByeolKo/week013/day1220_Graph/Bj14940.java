package week013.day1220_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj14940 {
    static int n, m, x, y;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static boolean[][] visited;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        x = 0;
        y = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    x = i;
                    y = j;
                    map[i][j] = 0;
                }
            }
        }

        bfs(x, y);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j]) {
                    System.out.print(map[i][j] + " ");
                } else {
                    if (map[i][j] == 0) {
                        System.out.print(0 + " ");
                    } else {
                        System.out.print(-1 + " ");
                    }
                }
            }
            System.out.println();
        }
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { x, y, 0 });
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            int distance = cur[2];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny]) {
                    if (map[nx][ny] != 0) {
                        visited[nx][ny] = true;
                        queue.add(new int[] { nx, ny, distance + 1 });
                        map[nx][ny] = distance + 1;
                    } else {
                        visited[nx][ny] = true;
                        map[nx][ny] = 0;
                    }
                }
            }
        }
    }
}
