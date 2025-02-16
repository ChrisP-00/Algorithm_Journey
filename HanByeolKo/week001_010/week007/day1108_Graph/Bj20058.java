package week001_010.week007.day1108_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj20058 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int size = 1 << n;
        int[][] graph = new int[size][size];

        for (int y = 0; y < size; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < size; x++) {
                graph[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        int[] subSize = new int[q];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < q; i++) {
            subSize[i] = 1 << Integer.parseInt(st.nextToken());

            for (int startY = 0; startY < size; startY+=subSize[i]) {
                for (int startX = 0; startX < size; startX+=subSize[i]) {
                    rotate(graph, startX, startY, subSize[i]);
                }
            }

            meltIce(graph,size);
        }

        int sum = 0;

        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                sum += graph[x][y];
            }
        }

        int max = findLargest(graph,size);

        System.out.println(sum);
        System.out.println(max);

    }

    public static void rotate(int[][] graph, int startX, int startY, int subSize) {
        int[][] temp = new int[subSize][subSize];

        for (int y = 0; y < subSize; y++) {
            for (int x = 0; x < subSize; x++) {
                temp[subSize - 1 - x][y] = graph[startX + y][startY + x];
            }
        }

        for (int y = 0; y < subSize; y++) {
            for (int x = 0; x < subSize; x++) {
                graph[startX + y][startY + x] = temp[y][x];
            }
        }
    }

    public static void meltIce(int[][] graph, int size) {
        int[][] temp = new int[size][size];

        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                temp[x][y] = graph[x][y];
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                if (graph[x][y] > 0) {
                    int iceCount = 0;

                    for (int i = 0; i < 4; i++) {
                        int nextX = x + dx[i];
                        int nextY = y + dy[i];

                        if (nextX >= 0 && nextX < size && nextY >= 0 && nextY < size && graph[nextX][nextY] > 0) {
                            iceCount++;
                        }
                    }

                    if(iceCount < 3){
                        temp[x][y] = graph[x][y] - 1;
                    }
                }
            }
        }

        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                graph[x][y] = temp[x][y];
            }
        }
    }

    public static int findLargest(int[][] graph, int size) {
        boolean[][] visited = new boolean[size][size];
        int maxSize = 0;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                if(graph[x][y] > 0 && !visited[x][y]){
                    int chuck = dfs(graph, visited, x, y, size, dx, dy);
                    maxSize = Math.max(maxSize, chuck);
                }
            }
        }

        return maxSize;
    }

    public static int dfs(int[][] graph, boolean[][] visited, int x, int y, int size, int[] dx, int[] dy) {
        visited[x][y] = true;
        int chunk = 1;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX >= 0 && nextX < size && nextY >= 0 && nextY < size && graph[nextX][nextY] > 0 && !visited[nextX][nextY]) {
                chunk += dfs(graph, visited, nextX, nextY, size, dx, dy);
            }
        }

        return chunk;
    }
}
