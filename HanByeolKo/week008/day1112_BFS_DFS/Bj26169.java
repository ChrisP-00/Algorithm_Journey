package week008.day1112_BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj26169 {
    static boolean[][] visited = new boolean[5][5];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] board = new int[5][5];
        for (int y = 0; y < 5; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int x = 0; x < 5; x++) {
                board[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        if (dfs(board, r, c, 0,0)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

    }

    private static boolean dfs(int[][] board, int r, int c, int depth, int apple) {
        if (depth > 3) {
            return false;
        }

        if (board[r][c] == 1) {
            apple++;
        }

        if (apple >= 2) {
            return true;
        }

        visited[r][c] = true;
        int origin = board[r][c];
        board[r][c] = -1;

        for (int i = 0; i < 4; i++) {
            int x = r + dx[i];
            int y = c + dy[i];

            if (x >= 0 && x <= 4 && y >= 0 && y <= 4 && !visited[x][y] && board[x][y] != -1) {
                if (dfs(board, x, y, depth + 1,apple)) {
                    return true;
                }
            }
        }

        board[r][c] = origin;
        visited[r][c] = false;
        return false;
    }
}
