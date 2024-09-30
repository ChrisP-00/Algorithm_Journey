package week001.day0930_Recursion;

import java.io.*;

public class Bj17478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int count = Integer.parseInt(br.readLine());

        String defaultQuestion = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n";
        String recursionQuestion1 = "\"재귀함수가 뭔가요?\"\n";
        String recursionQuestion2 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n";
        String recursionQuestion3 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n";
        String recursionQuestion4 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";
        String recursionAnswer1 = "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n";
        String recursionAnswer2 = "라고 답변하였지.\n";
        String underbar = "____";

        sb.append(defaultQuestion);

        for (int i = 0; i < count; i++) {
            printUnderbar(sb, i, underbar, recursionQuestion1);
            printUnderbar(sb, i, underbar, recursionQuestion2);
            printUnderbar(sb, i, underbar, recursionQuestion3);
            printUnderbar(sb, i, underbar, recursionQuestion4);
        }

        printUnderbar(sb, count, underbar, recursionQuestion1);
        printUnderbar(sb, count, underbar, recursionAnswer1);

        for (int j = count + 1; j > 0; j--) {
            sb.append(underbar.repeat(j - 1));
            sb.append(recursionAnswer2);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void printUnderbar(StringBuilder sb, int i, String underbar, String str) {
        sb.append(String.valueOf(underbar).repeat(Math.max(0, i)));
        sb.append(str);
    }
}
