package week011.day1204_Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(bfs(a,b));

    }

    private static int bfs(int a, int b) {
        Queue<Long> queue = new LinkedList<>();
        queue.offer((long) a);
        int count = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                long temp = queue.poll();

                if (temp == b) {
                    return count;
                }

                long next1 = temp * 2;
                long next2 = temp * 10 + 1;

                if(next1 <= b){
                    queue.offer(next1);
                }

                if(next2 <= b){
                    queue.offer(next2);
                }
            }
            count++;
        }

        return -1;
    }
}