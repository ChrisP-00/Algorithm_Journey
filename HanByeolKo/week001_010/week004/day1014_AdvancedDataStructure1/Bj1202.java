package week001_010.week004.day1014_AdvancedDataStructure1;

import java.io.*;
import java.util.*;

public class Bj1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int gemQty = Integer.parseInt(st.nextToken());
        int bagQty = Integer.parseInt(st.nextToken());

        List<List<Integer>> gemInfo = new ArrayList<>();
        List<Integer> bagInfo = new ArrayList<>();

        for (int i = 0; i < gemQty; i++) {
            st = new StringTokenizer(br.readLine());
            gemInfo.add(Arrays.asList(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        for (int i = 0; i < bagQty; i++) {
            bagInfo.add(Integer.parseInt(br.readLine()));
        }
        gemInfo.sort(Comparator.comparingInt(a -> a.get(0)));
        bagInfo.sort(Integer::compareTo);

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        int index = 0;
        long result = 0;

        for (int i = 0; i < bagQty; i++) {
            while (index < gemQty && gemInfo.get(index).get(0) <= bagInfo.get(i)) {
                priorityQueue.offer(gemInfo.get(index++).get(1));
            }

            if (!priorityQueue.isEmpty()) {
                result += priorityQueue.poll();
            }
        }
        System.out.println(result);

    }
}
