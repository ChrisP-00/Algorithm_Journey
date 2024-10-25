package week005.day1024_AdvancedDataStructure4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Bj10026 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static String[][] colors;
    static int N;
    static int result, result2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        colors = new String[N][N];
        visited = new boolean[N][N];

        for (int y = 0; y < N; y++) {
            String[] line = br.readLine().split("");
            for (int x = 0; x < N; x++) {
                colors[x][y] =line[x];
            }
        }

        result = 0;

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (!visited[x][y]) {
                    bfs(x, y);
                    result++;
                }
            }
        }

        result2 = 0;
        visited = new boolean[N][N];

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if(colors[x][y].equals("G")){
                    colors[x][y] = "R";
                }
            }
        }

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (!visited[x][y]) {
                    bfs(x, y);
                    result2++;
                }
            }
        }

        System.out.println(result + " " + result2);
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && colors[nx][ny].equals(colors[x][y])) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }

}
