package week011_020.week017.day0115_BackTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Bj5568 {
    static Set<String> numbers = new HashSet<>();
    static boolean[] visited;
    static List<String> card = new ArrayList<>();
    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            card.add(br.readLine());
        }

        visited = new boolean[n];

        generate("", 0);

        System.out.println(numbers.size());
    }

    private static void generate(String current, int depth){
        if(depth == k){
            numbers.add(current);
            return;
        }

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                generate(current + card.get(i), depth + 1);
                visited[i] = false;
            }
        }
    }
}
