package week011_020.week020;

import java.util.Scanner;
import java.util.Stack;
import java.util.stream.IntStream;

public class Bj2841 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int p = sc.nextInt();

        Stack<Integer>[] stacks = IntStream.range(0, 6)
                .mapToObj(i -> new Stack<Integer>())
                .toArray(Stack[]::new);

        int moves = 0;

        for (int i = 0; i < n; i++) {
            int line = sc.nextInt() - 1;
            int fret = sc.nextInt();

            while (!stacks[line].isEmpty() && stacks[line].peek() > fret) {
                stacks[line].pop();
                moves++;
            }

            if (stacks[line].isEmpty() || stacks[line].peek() < fret) {
                stacks[line].push(fret);
                moves++;
            }
        }

        System.out.println(moves);
    }
}
