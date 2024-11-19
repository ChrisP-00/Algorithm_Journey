package week009.day1119_String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Bj2866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] table = new char[R][C];
        for (int i = 0; i < R; i++) {
            table[i] = br.readLine().toCharArray();
        }

        int result = 0;

        long[] hashes = new long[C];
        long base = 31;
        long mod = 1_000_000_007;

        for (int i = 0; i < C; i++) {
            long hash = 0;
            for (int j = 0; j < R; j++) {
                hash = (hash * base + table[j][i]) % mod;
            }
            hashes[i] = hash;
        }

        for (int i = 0; i < R - 1; i++) {
            Set<Long> set = new HashSet<>();
            boolean isUnique = true;

            for (int j = 0; j < C; j++) {
                hashes[j] = (hashes[j] - table[i][j] * power(base, R - i - 1, mod) % mod + mod) % mod;

                if (!set.add(hashes[j])) {
                    isUnique = false;
                    break;
                }
            }

            if (!isUnique) {
                break;
            }
            result++;
        }

        System.out.println(result);
    }

    private static long power(long base, long exp, long mod) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
}
