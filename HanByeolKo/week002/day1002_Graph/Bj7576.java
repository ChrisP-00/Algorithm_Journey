package week002.day1002_Graph;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Bj7576 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] box = br.readLine().split(" ");

        int x = Integer.parseInt(box[1]);
        int y = Integer.parseInt(box[0]);
        int day = 0;

        int[][] tomato = new int[x][y];

        Queue<int[]> firstQue = new LinkedList<>();
        boolean isBadTomatato = false;

        String[] tomatoLine;

        for (int i = 0; i < x; i++) {
            tomatoLine = br.readLine().split(" ");
            for (int j = 0; j < y; j++) {
                tomato[i][j] = Integer.parseInt(tomatoLine[j]);

                if (tomato[i][j] == 1) {
                    firstQue.offer(new int[]{i, j});
                }else if (tomato[i][j] == 0) {
                    isBadTomatato = true;
                }
            }
        }

        if (!isBadTomatato) {
            bw.write("0\n");
            bw.flush();
            bw.close();
            return;
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        if(firstQue.isEmpty()) {
            day = -1;
        }

        while (!firstQue.isEmpty()) {
            int size = firstQue.size();
            boolean isGoodTomatato = false;

            for (int i = 0; i < size; i++) {
                int[] base = firstQue.poll();

                for (int j = 0; j < 4; j++) {
                    int nx = base[0] + dx[j];
                    int ny = base[1] + dy[j];

                    if (nx >= 0 && nx < x && ny >= 0 && ny < y && tomato[nx][ny] == 0) {
                        tomato[nx][ny] = 1;
                        firstQue.offer(new int[]{nx, ny});
                        isGoodTomatato = true;
                    }
                }
            }

            if (isGoodTomatato) {
                day++;
            }
        }

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (tomato[i][j] == 0) {
                    day = -1;
                    break;
                }
            }
        }

        bw.write(day + "\n");
        bw.flush();
        bw.close();
    }
}
