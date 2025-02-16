package week011_020.week011.day1203_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj14502 {
    private static int n, m;
    private static int[][] graph;
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(max);
    }

    private static void dfs(int wall) {
        if (wall == 3) {
            int[][] tempGraph = copyGraph(graph);
            bfs(tempGraph);
            max = Math.max(max, countSafeArea(tempGraph));
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0) {
                    graph[i][j] = 1;
                    dfs(wall + 1);
                    graph[i][j] = 0;
                }
            }
        }
    }

    private static void bfs(int[][] tempGraph) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tempGraph[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || tempGraph[nx][ny] != 0) {
                    continue;
                }

                tempGraph[nx][ny] = 2;
                queue.offer(new int[]{nx, ny});
            }
        }
    }

    private static int countSafeArea(int[][] tempGraph) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tempGraph[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int[][] copyGraph(int[][] original) {
        int[][] copy = new int[n][m];
        for (int i = 0; i < n; i++) {
            System.arraycopy(original[i], 0, copy[i], 0, m);
        }
        return copy;
    }
}