package week011_020.week019;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Bj3190 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] map = new int[n + 1][n + 1];
        Map<Integer, Character> turn = new HashMap<>();
        int[] dx = new int[] { 0, 1, 0, -1 };
        int[] dy = new int[] { 1, 0, -1, 0 };
        int[] d = new int[] { 0 };
        Deque<int[]> q = new LinkedList<>(List.of(new int[] { 1, 1 }));

        for (int i = sc.nextInt(); i-- > 0;)
            map[sc.nextInt()][sc.nextInt()] = 1;
        for (int i = sc.nextInt(); i-- > 0;)
            turn.put(sc.nextInt(), sc.next().charAt(0));
        sc.close();
        System.out.println(new Object() {
            int time = 0;

            int move() {
                for (;; time++) {
                    int[] h = q.peekFirst();
                    var nx = h[0] + dx[d[0]];
                    var ny = h[1] + dy[d[0]];
                    if (nx <= 0 || ny <= 0 || nx > n || ny > n || q.stream().anyMatch(p -> p[0] == nx && p[1] == ny))
                        return time + 1;
                    q.addFirst(new int[] { nx, ny });
                    if (map[nx][ny] == 0)
                        q.pollLast();
                    else
                        map[nx][ny] = 0;
                    turn.computeIfPresent(time + 1, (k, v) -> {
                        d[0] = v == 'L' ? (d[0] + 3) % 4 : (d[0] + 1) % 4;
                        return v;
                    });
                }
            }
        }.move());
    }
}
