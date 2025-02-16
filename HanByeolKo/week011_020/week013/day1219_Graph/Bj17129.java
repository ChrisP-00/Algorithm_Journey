package week011_020.week013.day1219_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj17129 {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        int startX = 0;
        int startY = 0;
        boolean[][] visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = str.charAt(j)-'0';
                if(map[i][j] == 2){
                    startX = i;
                    startY = j;
                }
            }
        }

        System.out.println(bfs(startX,startY,n,m,map,visited));
    }

    private static String bfs(int x, int y, int n, int m, int[][] map, boolean[][] visited){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x,y,0});
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            int distance = cur[2];

            if(map[cx][cy] == 3 || map[cx][cy] == 4 || map[cx][cy] == 5){
                return "TAK\n" + distance;
            }

            for(int i = 0; i < 4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && map[nx][ny] != 1){
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx,ny,distance+1});
                }
            }
        }

        return "NIE";
    }
}
