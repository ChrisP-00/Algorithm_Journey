package week008.day1111_BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj16173 {
    private static boolean[][] visited;
    private static int N;
    private static int[] dx = {1, 0};
    private static int[] dy = {0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        for (int y = 0; y < N; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                board[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][N];

        if (dfs(0, 0, board)) {
            System.out.println("HaruHaru");
        } else {
            System.out.println("Hing");
        }

    }

    private static boolean dfs(int x, int y, int[][] board) {
        if(board[x][y] == -1){
            return true;
        }

        visited[x][y] = true;

        int move = board[x][y];

        for (int i = 0; i < 2; i++) {
            int nx = x + dx[i] * move;
            int ny = y + dy[i] * move;

            if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                if (dfs(nx, ny, board)) {
                    return true;
                }
            }
        }

        return false;
    }
}
