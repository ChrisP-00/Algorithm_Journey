package week001.day0923_String;

import java.io.*;
import java.util.Stack;

public class Bj9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int number = Integer.parseInt(br.readLine());

        for (int i = 0; i < number; i++) {
            sb.append(judge(br.readLine()));
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static String judge(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '(') {
                stack.push(c);
            }else if(c == ')'){
                if(stack.isEmpty()){
                    return "NO";
                }else if(stack.peek() == '('){
                    stack.pop();
                }
            }
        }

        if(stack.isEmpty()){
            return "YES";
        }else {
            return "NO";
        }
    }
}
