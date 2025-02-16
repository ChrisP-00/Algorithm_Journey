package week001_010.week006.day1029_Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj23351 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] pot = new int[N];

        for (int i = 0; i < N; i++) {
            pot[i] = K;
        }

        int result = 0;
        int startIdx = 0;

        while (true) {
            result++;

            pot = water(pot, startIdx, A, B);
            pot = dayAfter(pot);

            startIdx = (startIdx + A) % N;

            if (isDead(pot)) {
                System.out.println(result);
                break;
            }
        }
    }

    private static  int[] dayAfter(int[] pot) {
        for (int i = 0; i < pot.length; i++) {
            pot[i] -= 1;
        }

        return pot;
    }

    private static int[] water( int[] pot, int start, int A, int B) {
        for (int j = 0; j < A; j++) {
            int idx = (start + j) % pot.length;
            pot[idx] += B;
        }

        return pot;
    }

    private static boolean isDead(int[] pot) {
        for (int water : pot) {
            if (water <= 0) {
                return true;
            }
        }

        return false;
    }
}
