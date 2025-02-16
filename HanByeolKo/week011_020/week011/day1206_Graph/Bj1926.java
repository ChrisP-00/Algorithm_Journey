package week011_020.week011.day1206_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Bj1926 {
    private static int n, m;
    private static int[][] graph;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visited[i][j] && (graph[i][j] == 1)) {
                    result.add(dfs(i,j));
                }
            }
        }

        if (result.isEmpty()) {
            System.out.println(0);
            System.out.println(0);
            return;
        }

        Collections.sort(result);

        System.out.println(result.size());
        System.out.println(result.get(result.size() - 1));
    }

    private static int dfs(int x, int y) {
        int size = 1;
        visited[x][y] = true;

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];

            if(nx >= 0 && ny >= 0 && nx < n && ny < m && graph[nx][ny] == 1 && !visited[nx][ny]){
                size += dfs(nx, ny);
            }

        }

        return size;
    }
}
