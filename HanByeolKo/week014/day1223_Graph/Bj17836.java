package week014.day1223_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj17836 {
    static int n, m, t;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean hasSuperPower = false;
    static int minTime = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(0, 0);

        if (minTime <= t) {
            System.out.println(minTime);
        } else {
            System.out.println("Fail");
        }
    }

    public static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, 0});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            int time = cur[2];

            if (cx == n - 1 && cy == m - 1) {
                minTime = Math.min(minTime, time);
                continue;
            }

            if (time > t)
                continue;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny]) {
                    if (!hasSuperPower) {
                        if (map[nx][ny] != 1) {
                            visited[nx][ny] = true;
                            queue.add(new int[]{nx, ny, time + 1});
                            if (map[nx][ny] == 2) {
                                hasSuperPower = true;
                            }
                        }
                    } else {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny, time + 1});
                    }
                }
            }
        }
    }
}