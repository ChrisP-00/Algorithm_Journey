package week001_010.week002.day0930_Recursion;

import java.io.*;

public class Bj11729 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int disk = Integer.parseInt(br.readLine());

        int moves = (int)Math.pow(2,disk) - 1;
        sb.append(moves).append("\n");

        hanoi(sb,disk,1,2,3);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void hanoi(StringBuilder sb, int disk, int first, int second, int third){
        if (disk == 1) {
            // 디스크가 하나일 경우 시작 기둥에서 목표 기둥으로 옮긴다
            sb.append(first).append(" ").append(third).append("\n");
            return;
        }
        // 가장 큰 디스크 하나만 두고 나머지를 시작 기둥에서 두번째 기둥으로 옮긴다
        hanoi(sb,disk - 1, first, third, second);
//        if (disk == 1) {
//            // 디스크가 하나일 경우 시작 기둥에서 목표 기둥으로 옮긴다
//            sb.append(first).append(" ").append(second).append("\n");
//            return;
//        }

        // 가장 큰 디스크를 시작 기둥에서 목표 기둥으로 옮긴다
        sb.append(first).append(" ").append(third).append("\n");
        // 두번째 기둥에 있는 디스크를 목표 기둥으로 옮긴다
        hanoi(sb,disk - 1, second, first, third);
    }
}
