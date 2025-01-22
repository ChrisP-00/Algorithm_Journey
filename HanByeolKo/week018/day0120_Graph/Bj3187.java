package week018.day0120_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj3187 {
    static int r,c;
    static boolean[][] visited;
    static String[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        visited = new boolean[r][c];
        map = new String[r][c];

        for(int i = 0; i < r; i++){
            String str = br.readLine();
            for(int j = 0; j < c; j++){
                map[i][j] = String.valueOf(str.charAt(j));
            }
        }

        int sheep = 0;
        int wolf = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!visited[i][j] && !map[i][j].equals("#")) {
                    int[] result = dfs(i, j);
                    if (result[0] > result[1]) {
                        sheep += result[0];
                    } else {
                        wolf += result[1];
                    }
                }
            }
        }

        System.out.println(sheep + " " + wolf);
    }

    static int[] dfs(int x, int y){
        visited[x][y] = true;
        int sheep = 0;
        int wolf = 0;

        if(map[x][y].equals("k")){
            sheep++;
        }
        if(map[x][y].equals("v")){
            wolf++;
        }

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < r && ny >= 0 && ny < c && !visited[nx][ny] && !map[nx][ny].equals("#")) {
                int[] result = dfs(nx, ny);
                sheep += result[0];
                wolf += result[1];
            }
        }

        return new int[]{sheep, wolf};
    }
}
