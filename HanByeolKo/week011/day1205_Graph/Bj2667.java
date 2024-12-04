package week011.day1205_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Bj2667 {
    private static int[] dx ={-1, 1, 0, 0};
    private static int[] dy ={0, 0, -1, 1};
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                graph[i][j] = s.charAt(j) - '0';
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j] && (graph[i][j] == 1)) {
                    result.add(dfs(graph,i,j,N));
                }
            }
        }

        System.out.println(result.size());
        result.stream().sorted().forEach(System.out::println);
    }

    private static int dfs(int[][] graph, int x, int y, int N) {
        visited[x][y] = true;
        int count = 1;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && graph[nx][ny] == 1) {
                count += dfs(graph, nx, ny, N);
            }
        }

        return count;
    }
}
