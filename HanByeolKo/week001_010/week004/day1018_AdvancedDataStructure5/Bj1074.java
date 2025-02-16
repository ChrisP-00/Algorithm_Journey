package week001_010.week004.day1018_AdvancedDataStructure5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1074 {
    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int shift = n - 1;
        int boardLength = 2 << shift;

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        find(r,c,boardLength);
        System.out.println(count);
    }

    private static void find(int r, int c, int size) {
        int halfSize = size >> 1;
        int powSize = size * size;

        if (size == 1) {
            return;
        }
        if (r < halfSize && c < halfSize) {
            find(r, c, halfSize);
        }
        if (r < halfSize && c >= halfSize) {
            count += powSize >> 2;
            find(r, c - halfSize, halfSize);
        }
        if (r >= halfSize && c < halfSize) {
            count += powSize >> 1;
            find(r - halfSize, c, halfSize);
        }
        if (r >= halfSize && c >= halfSize) {
            count += (powSize >> 2) * 3;
            find(r - halfSize, c - halfSize, halfSize);
        }

    }
}
