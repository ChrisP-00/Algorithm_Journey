package week001.day0924_StackAndQueue;

import java.io.*;
import java.util.Stack;

public class Bj2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int number = Integer.parseInt(br.readLine());
        int[] arr = new int[number];
        String[] s = br.readLine().split(" ");

        for (int i = 0; i < number; i++) {
            arr[i] = Integer.parseInt(s[i]);
            stack.push(arr[i]);
        }
        // [6,9,5,7,4]

        // 뒤에서부터 확인하면 조짐... ex : 9 6 5 7 4

//        int temp = 0;
//
//        for (int i = number-1; i >= 0; i--) {
//            stack.pop();
//            if (stack.isEmpty()) {
//                sb.append(0);
//            }else if (stack.peek() >= arr[i]) {
//                while (temp != 0) {
//                    sb.append(i).append(" ");
//                    temp--;
//                }
//                sb.append(i).append(" ");
//            } else {
//                temp++;
//            }
//        }

        bw.write(sb.reverse().toString());
        bw.flush();
        bw.close();
    }
}
