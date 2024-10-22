package week005.day1022_AdvancedDataStructure2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Bj2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int computer = Integer.parseInt(br.readLine());
        int network = Integer.parseInt(br.readLine());

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < network; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
            map.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
        }

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> result = new HashSet<>();
        queue.add(1);

        if(map.containsKey(1)) {
            for (int i = 0; i < map.get(1).size(); i++) {
                queue.add(map.get(1).get(i));
                result.add(map.get(1).get(i));
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if(map.get(current) != null) {
                for (int i = 0; i < map.get(current).size(); i++) {
                    int next = map.get(current).get(i);
                    if (!result.contains(next)) {
                        queue.add(next);
                        result.add(next);
                    }
                }
            }
        }

        if(!result.isEmpty()){
            System.out.println(result.size()-1);
        }else {
            System.out.println(0);
        }

    }
}
