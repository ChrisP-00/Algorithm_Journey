package week001.day0926_Hash;

import java.io.*;
import java.math.BigInteger;

public class Bj15829 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int length = Integer.parseInt(br.readLine());
        char[] str = br.readLine().toCharArray();

        int hashAlpha;
        BigInteger hash = BigInteger.valueOf(0);
        BigInteger num = BigInteger.valueOf(31);
        BigInteger m = BigInteger.valueOf(1234567891);

        for (int i = 0; i < length; i++) {
            hashAlpha = str[i] - 96;
            hash = hash.add(BigInteger.valueOf(hashAlpha).multiply(num.modPow(BigInteger.valueOf(i),m)));
        }

        bw.write(hash.toString());
        bw.flush();
        bw.close();

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int length = Integer.parseInt(br.readLine());
//        char[] chars = br.readLine().toCharArray();
//
//        int hashAlpha;
//        long hash = 0;
//        long mod = 1234567891;
//
//        for (int i = 0; i < length; i++) {
//            hashAlpha = chars[i] - 'a' + 1;
//            hash = (hash + hashAlpha * pow(31, i, mod)) % mod;
//        }
//
//        bw.write(Long.toString(hash));
//        bw.flush();
//        bw.close();
//    }
//
//    public static long pow(long base, long exp, long mod) {
//        if (exp == 0) return 1;
//        long half = pow(base, exp / 2, mod);
//        long result = (half * half) % mod;
//        if (exp % 2 != 0) result = (result * base) % mod;
//        return result;
    }
}
