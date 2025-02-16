package week001_010.week006.day1029_Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Bj26215 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            queue.add(Integer.parseInt(st.nextToken()));
        }

        int count = 0;

        while (!queue.isEmpty()) {
            int pop1 = queue.poll();
            pop1--;

            if(!queue.isEmpty()) {
                int pop2 = queue.poll();
                pop2--;
                if (pop2 != 0) {
                    queue.add(pop2);
                }
            }

            if (pop1 != 0) {
                queue.add(pop1);
            }

            count++;
        }

        if(count > 1440){
            count = -1;
        }

        System.out.println(count);
    }
}
