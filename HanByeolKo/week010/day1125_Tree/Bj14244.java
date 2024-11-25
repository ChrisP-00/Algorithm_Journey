package week010.day1125_Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj14244 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int straight = n - m;

        int nodeB = 0;

        for (int i = 0; i < straight; i++) {
            nodeB = i + 1;
            System.out.println(i + " " + nodeB);
        }

        for (int i = nodeB + 1; i < n; i++) {
            System.out.println(nodeB + " " + i);
        }
    }
}
