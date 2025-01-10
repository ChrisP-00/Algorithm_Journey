package week016.day0109_Map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Bj22252 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(br.readLine());
        long sum = 0;

        Map<String, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            int count = Integer.parseInt(st.nextToken());

            if (type == 1) {
                List<Integer> list = map.getOrDefault(name, new ArrayList<>());
                while (st.hasMoreTokens()) {
                    list.add(Integer.parseInt(st.nextToken()));
                }

                map.put(name, list);
            }

            if (type == 2) {
                List<Integer> list = map.get(name);

                if (list == null || list.isEmpty()) {
                    continue;
                }

                list.sort(Comparator.reverseOrder());

                for (int j = 0; j < count && !list.isEmpty(); j++) {
                    sum += list.get(0);
                    list.remove(0);
                }
            }
        }

        System.out.println(sum);
    }
}
