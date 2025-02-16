package week001_010.week005.day1023_AdvancedDataStructure3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj21736 {
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static boolean[][] visited;
    private static int[] start = new int[2];
    private static int count = 0;
    private static char[][] campus;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        campus = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                campus[i][j] = line.charAt(j);
                System.out.print(campus[i][j] + " ");
                if (campus[i][j] == 'I') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        dfs(start[0], start[1]);

        if (count == 0) {
            System.out.println("TT");
        } else {
            System.out.println(count);
        }
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX >= 0 && newY >= 0 && newX < campus.length && newY < campus[0].length) {
                if (!visited[newX][newY]) {
                    if (campus[newX][newY] == 'X') {
                        continue;
                    }

                    if (campus[newX][newY] == 'P') {
                        System.out.println("친구" + newX + "-" + newY);
                        count += 1;
                    }
                    visited[newX][newY] = true;
                    dfs(newX, newY);
                }
            }
        }

    }
}
