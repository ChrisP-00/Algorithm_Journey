package week018.day0122_Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Bj12933 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sound = br.readLine();

        if (sound.length() % 5 != 0) {
            System.out.println(-1);
            return;
        }

        List<Stack<Character>> stacks = new ArrayList<>();
        int max = 0;

        for (char c : sound.toCharArray()) {
            boolean checked = false;

            for (Stack<Character> stack : stacks) {
                if (isValid(stack, c)) {
                    stack.push(c);
                    checked = true;
                    break;
                }
            }

            if (!checked) {
                if (c != 'q') {
                    System.out.println(-1);
                    return;
                }
                Stack<Character> newStack = new Stack<>();
                newStack.push(c);
                stacks.add(newStack);
                max = Math.max(max, stacks.size());
            }

            for (int i = 0; i < stacks.size(); i++) {
                if (stacks.get(i).size() == 5) {
                    stacks.remove(i);
                    break;
                }
            }
        }

        if (!stacks.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(max);
        }
    }

    private static boolean isValid(Stack<Character> stack, char c) {
        String quack = "quack";
        if (stack.isEmpty()) {
            return c == 'q';
        }
        int current = quack.indexOf(stack.peek());
        int next = quack.indexOf(c);
        return next == current + 1;
    }
}
