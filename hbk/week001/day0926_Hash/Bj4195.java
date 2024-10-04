package week001.day0926_Hash;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Bj4195 {
    private static Map<String, String> parent = new HashMap<>();
    private static Map<String, Integer> cnt = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCases = Integer.parseInt(br.readLine());

        while (testCases-- > 0) {
            int network = Integer.parseInt(br.readLine());
            parent.clear();
            cnt.clear();
            for (int i = 0; i < network; i++) {
                String[] input = br.readLine().split(" ");
                String node1 = input[0];
                String node2 = input[1];

                if (!parent.containsKey(node1)) {
                    parent.put(node1, node1);
                    cnt.put(node1, 1);
                }

                if (!parent.containsKey(node2)) {
                    parent.put(node2, node2);
                    cnt.put(node2, 1);
                }

                union(node1, node2);
                bw.write(cnt.get(find(node1)) + "\n");
            }
        }
        bw.flush();
        bw.close();
    }

    private static String find(String node) {
        if (node.equals(parent.get(node))) {
            return node;
        }
        String p = find(parent.get(node));
        parent.put(node, p);
        return p;
    }

    private static void union(String node1, String node2) {
        String p1 = find(node1);
        String p2 = find(node2);

        if (!p1.equals(p2)) {
            parent.put(p2, p1);
            cnt.put(p1, cnt.get(p1) + cnt.get(p2));
        }
    }


}
