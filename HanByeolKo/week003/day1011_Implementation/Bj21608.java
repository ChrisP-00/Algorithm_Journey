package week003.day1011_Implementation;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Bj21608 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int row = Integer.parseInt(br.readLine());
        int students = row * row;

        List<List<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < students; i++) {
            List<Integer> friend = new ArrayList<>(Arrays.stream(br.readLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList()));
            lists.add(friend);
        }

        int[][] seats = new int[row][row];
        boolean isEmpty;

//        if(lists.get(1).stream().noneMatch(num -> num == seats[1][1])){
//            seats[0][0] = lists.get(1).getFirst();
//        }else{
//            seats[0][1] = lists.get(1).getFirst();
//        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                int std = 1 << i;
                int idx = i + j + std;
                isEmpty = seats[i][j] == 0;

                // 0, 1, 2 x+y+0
                // 3, 4 ,5 x+y+2
                // 6, 7, 8 x+y+4
                // 9, 10, 11 x+y+6

                if(std == 1){
                    idx = i + j;
                }

                if(isEmpty) {
                    seats[i][j] = lists.get(idx).getFirst();
                }

                if(idx == 0){
                    seats[1][1] = lists.getFirst().getFirst();
                }

                System.out.print(seats[i][j] + " ");
            }
            System.out.println();
        }

    }
}
