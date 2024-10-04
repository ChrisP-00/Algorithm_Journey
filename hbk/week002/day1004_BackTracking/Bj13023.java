package week002.day1004_BackTracking;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Bj13023 {
    private static int result = 0;
    private static boolean[] visited;
    private static List<List<Integer>> friendList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int person = Integer.parseInt(input[0]);
        int friend = Integer.parseInt(input[1]);

        visited = new boolean[person];
        friendList = new ArrayList<>();

        for (int i = 0; i < person; i++) {
            friendList.add(new ArrayList<>());
        }

        for (int i = 0; i < friend; i++) {
            String[] friendInput = br.readLine().split(" ");
            int person1 = Integer.parseInt(friendInput[0]);
            int person2 = Integer.parseInt(friendInput[1]);

            friendList.get(person1).add(person2);
            friendList.get(person2).add(person1);
        }

        for (int i = 0; i < person; i++) {
            if (result == 0)
                dfs(i, 1);
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }

    private static void dfs(int start, int depth) {
        if (depth == 5) {
            result = 1;
            return;
        }

        visited[start] = true;
        for (int i : friendList.get(start)) {
            int next = i;
            if (!visited[next]) {
                dfs(next, depth + 1);
            }
        }
        visited[start] = false;
    }
}
