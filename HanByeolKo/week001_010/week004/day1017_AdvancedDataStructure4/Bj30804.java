package week001_010.week004.day1017_AdvancedDataStructure4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Bj30804 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        int max = 0;
        int left = 0;
//        int[] tang = new int[2];
//        int tang0conut = 0;
//        int tang1count = 0;
//
//        for (int i = 0; i < N; i++) {
//            arr[i] = Integer.parseInt(st.nextToken());
//        }
//
//        tang[0] = arr[0];
//
//        for (int i = 0; i < N; i++) {
//            if (arr[i] == tang[0]) {
//                tang0conut++;
//            } else if (arr[i] == tang[1]) {
//                arr[i] = tang[1];
//                tang1count++;
//            } else if (arr[i] != tang[0] && arr[i] != tang[1]) {
//                max = Math.max(max, tang0conut + tang1count);
//                tang[0] = tang[1];
//                tang[1] = arr[i];
//                tang0conut = tang1count;
//                tang1count = 1;
//                left++;
//            }
//        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

            while (map.size() > 2) {
                map.put(arr[left], map.get(arr[left]) - 1);

                if (map.get(arr[left]) == 0) {
                    map.remove(arr[left]);
                }

                left++;
            }

            max = Math.max(max, i - left + 1);
        }

        System.out.println(max);
    }
}
