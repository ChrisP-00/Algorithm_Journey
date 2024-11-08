package week007.day1107_Heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Bj7662 {

    private static final char INSERT_COMMAND = 'I';
    private static final char DELETE_COMMAND = 'D';

    private static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCases; i++) {
            int operations = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();
            excute(operations, map);
        }
    }

    private static void excute(int operations, TreeMap<Integer, Integer> map) throws IOException {
        for (int j = 0; j < operations; j++) {
            process(map);
        }
        printResult(map);
    }

    private static String readLine() throws IOException {
        return br.readLine();
    }

    private static void process(TreeMap<Integer, Integer> map) throws IOException {
        String[] input = readLine().split(" ");
        char command = input[0].charAt(0);
        int value = Integer.parseInt(input[1]);
        if (command == INSERT_COMMAND) {
            insert(map, value);
        }else if(command == DELETE_COMMAND){
            delete(map, value);
        }
    }

    private static void insert(TreeMap<Integer, Integer> map, int value) {
        map.put(value, map.getOrDefault(value, 0) + 1);
    }

    private static void delete(TreeMap<Integer, Integer> map, int value) {
        if (map.isEmpty()){
            return;
        }
        int key = value == 1 ? map.lastKey() : map.firstKey();
        if(map.put(key, map.get(key) - 1) == 1){
            map.remove(key);
        }
    }

    public static void printResult(TreeMap<Integer, Integer> map) throws IOException {
        if (map.isEmpty()){
            System.out.println("EMPTY");
        }else {
            System.out.println(map.lastKey() + " " + map.firstKey());
        }
    }
}
