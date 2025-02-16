package week001_010.week002.day1003_BFS_DFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Bj2573 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] icebug = br.readLine().split(" ");

        int x = Integer.parseInt(icebug[0]);
        int y = Integer.parseInt(icebug[1]);
        int year = 0;

        int[][] ice = new int[x][y];

        String[] iceLine;

        for (int i = 0; i < x; i++) {
            iceLine = br.readLine().split(" ");
            for (int j = 0; j < y; j++) {
                ice[i][j] = Integer.parseInt(iceLine[j]);
            }
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        while (true) {
            int icebergs = countIcebergs(ice, x, y);

            if (icebergs >= 2) {
                break;
            }

            if (icebergs == 0) {
                year = 0;
                break;
            }

            int[][] newIce = new int[x][y];

            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    if(ice[i][j] > 0) {
                        int count = 0;
                        for (int k = 0; k < 4; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];

                            if (nx >= 0 && nx < x && ny >= 0 && ny < y && ice[nx][ny] == 0) {
                                count++;
                            }
                        }

                        newIce[i][j] = Math.max(ice[i][j]-count, 0);
                    }
                }
            }

            ice = newIce;
            year++;
        }

        bw.write(year + "\n");
        bw.flush();
        bw.close();
    }

    public static int countIcebergs(int[][] ice, int x, int y) {
        boolean[][] visited = new boolean[x][y];
        int count = 0;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (ice[i][j] > 0 && !visited[i][j]) {
                    bfs(ice, visited, i, j, x, y);
                    count++;
                }
            }
        }

        return count;
    }

    public static void bfs(int[][] ice, boolean[][] visited, int startX, int startY, int x, int y) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && nx < x && ny >= 0 && ny < y && !visited[nx][ny] && ice[nx][ny] > 0) {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }

}
