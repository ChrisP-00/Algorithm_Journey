package week001_010.week004.day1016_AdvancedDataStructure3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj14500 {
    private static int max;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int N;
    private static int M;
    private static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visited = new boolean[N][M];

        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < M; x++) {
                board[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        max = 0;

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                visited[y][x] = true;
                dfs(y,x,1,board[y][x]);
                bfs(y,x);
                visited[y][x] = false;
            }
        }

        System.out.println(max);

        br.close();

    }

    private static void bfs(int y, int x){
        int sum = board[y][x];
        int minValue = 1001;
        int directions = 0;

        for (int i = 0; i < 4; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];

            if (newY < 0 || newX < 0 || newY >= N || newX >= M) {
                continue;
            }

            sum += board[newY][newX];
            minValue = Math.min(minValue, board[newY][newX]);
            directions++;
        }

        if (directions == 3) {
            max = Math.max(max, sum);
        }
        if (directions == 4) {
            max = Math.max(max, sum - minValue);
        }
    }

    private static void dfs(int y, int x, int depth, int sum){
        if (depth == 4){
            max = Math.max(max, sum);
            return;
        }

        for(int i = 0; i < 4; i++){
            int newY = y + dy[i];
            int newX = x + dx[i];

            if (newY < 0 || newX < 0 || newY >= N || newX >= M){
                continue;
            }

            if(visited[newY][newX]){
                continue;
            }

            visited[newY][newX] = true;
            dfs(newY, newX, depth+1, sum + board[newY][newX]);
            visited[newY][newX] = false;
        }
    }
}
