package week001.day0924_StackAndQueue;

import java.io.*;
import java.util.Stack;

public class Bj2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Stack<int[]> stack = new Stack<>();

        int number = Integer.parseInt(br.readLine());
        int[] arr = new int[number];
        String[] s = br.readLine().split(" ");

        for (int i = 0; i < number; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }
        // [6,9,5,7,4]

        for (int i = 0; i < number; i++) {
            while (!stack.isEmpty() && stack.peek()[1] < arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                sb.append(stack.peek()[0] + 1).append(" ");
            }else {
                sb.append(0).append(" ");
            }

            stack.push(new int[]{i, arr[i]});
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
