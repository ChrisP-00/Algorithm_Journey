package week011_020.week018.day0124_Implementation;

import java.util.Scanner;

public class Bj1138 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] result = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int pos = arr[i];
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (result[j] == 0) {
                    if (count == pos) {
                        result[j] = i + 1;
                        break;
                    }
                    count++;
                }
            }
        }

        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
