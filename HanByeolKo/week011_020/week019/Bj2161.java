package week011_020.week019;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bj2161 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Queue<Integer> q = new LinkedList<>();
        int n = sc.nextInt();
        for(int i = 1; i <= n; i++){
            q.offer(i);
        }

        while (q.size() > 1){
            System.out.print(q.poll() + " ");
            q.offer(q.poll());
        }

        System.out.println(q.poll());
    }
}
