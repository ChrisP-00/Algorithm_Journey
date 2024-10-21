package week005.day1021_AdvancedDataStructure1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1012 {
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int column;
    static int row;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            result = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());

            column = Integer.parseInt(st.nextToken());
            row = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());

            int[][] cabbage = new int[row][column];
            visited = new boolean[row][column];

            for (int i = 0; i < count; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                cabbage[y][x] = 1;
            }

            for (int y = 0; y < cabbage.length; y++) {
                for (int x = 0; x < cabbage[y].length; x++) {
                    if (cabbage[y][x] == 1 && !visited[y][x]) {
                        dfs(cabbage, y, x);
                        result++;
                    }
                }
            }

            System.out.println(result);
        }
    }


    static void dfs(int[][] cabbage, int y, int x) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newY < 0 || newX < 0 || newY >= row || newX >= column) {
                continue;
            }

            if (cabbage[newY][newX] == 1 && !visited[newY][newX]) {
                dfs(cabbage, newY, newX);
            }
        }
    }

}
