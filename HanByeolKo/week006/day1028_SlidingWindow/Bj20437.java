package week006.day1028_SlidingWindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Bj20437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCases; i++) {
            String w = br.readLine();
            int k = Integer.parseInt(br.readLine());
            int min = lengthMin(w, k);
            int max = lengthMax(w, k);

            if (min == -1 && max == -1) {
                System.out.println(min);
            } else {
                System.out.println(min + " " + max);
            }
        }
    }

    private static HashMap<Character, List<Integer>> map(String s) {
        HashMap<Character, List<Integer>> positionMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            positionMap.putIfAbsent(c, new ArrayList<>());
            positionMap.get(c).add(i);
        }

        return positionMap;
    }

    private static int lengthMin(String w, int k) {
        HashMap<Character, List<Integer>> positionMap = map(w);

        int minLength = Integer.MAX_VALUE;

        for (List<Integer> positions : positionMap.values()) {
            if (positions.size() >= k) {
                for (int i = 0; i <= positions.size() - k; i++) {
                    int newLength = positions.get(i + k - 1) - positions.get(i) + 1;
                    minLength = Math.min(minLength, newLength);
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    private static int lengthMax(String w, int k) {
        HashMap<Character, List<Integer>> positionMap = map(w);

        int maxLength = Integer.MIN_VALUE;

        for (List<Integer> positions : positionMap.values()) {
            if (positions.size() >= k) {
                for (int i = 0; i <= positions.size() - k; i++) {
                    int newLength = positions.get(i + k - 1) - positions.get(i) + 1;
                    maxLength = Math.max(maxLength, newLength);
                }
            }
        }

        return maxLength == Integer.MIN_VALUE ? -1 : maxLength;
    }

//    private static int lengthMax(String str, int k){
//        String[] strs = str.split("");
//        List<String> list = new ArrayList<>(Arrays.asList(strs));
//        Set<String> set = new HashSet<>();
//
//        list.stream()
//                .filter(i -> Collections.frequency(list, i) == k)
//                .forEach(set::add);
//
//        Stack<String> stack = new Stack<>();
//
//        for (String s : set) {
//            stack.push(s);
//        }
//
//        int max = 0;
//
//        while (!stack.isEmpty()) {
//            String key = stack.pop();
//            int first = str.indexOf(key);
//            int second = str.lastIndexOf(key);
//
//            String sub = str.substring(first, second+1);
//
//            max = Math.max(max, sub.length());
//        }
//
//        return max;
//    }
//
//    private static int lengthMin(String str, int k){
//        return str.length();
//    }
}
