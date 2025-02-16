package week001_010.week001.day0925_Deque;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Bj10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int lines = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < lines; i++) {
            String command = br.readLine();
            String result = "-1";

//            push_front X: 정수 X를 덱의 앞에 넣는다.
//            push_back X: 정수 X를 덱의 뒤에 넣는다.
//            pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//            pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//            size: 덱에 들어있는 정수의 개수를 출력한다.
//            empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
//            front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
//            back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.

            if (command.contains("push_front")) {
                deque.offerFirst(Integer.parseInt(command.split(" ")[1]));
                continue;
            } else if (command.contains("push_back")) {
                deque.offerLast(Integer.parseInt(command.split(" ")[1]));
                continue;
            } else if (command.contains("pop_front")) {
                if (!deque.isEmpty()) {
                    result = Integer.toString(deque.pollFirst());
                }
            } else if (command.contains("pop_back")) {
                if (!deque.isEmpty()) {
                    result = Integer.toString(deque.pollLast());
                }
            } else if (command.contains("size")) {
                result = Integer.toString(deque.size());
            } else if (command.contains("empty")) {
                if (deque.isEmpty()) {
                    result = "1";
                }else{
                    result = "0";
                }
            } else if (command.equals("front")) {
                if (!deque.isEmpty()) {
                    result = Integer.toString(deque.peekFirst());
                }
            } else if (command.equals("back")) {
                if (!deque.isEmpty()) {
                    result = Integer.toString(deque.peekLast());
                }
            }

            bw.write(result+"\n");
            bw.flush();
        }
        bw.close();
    }
}
