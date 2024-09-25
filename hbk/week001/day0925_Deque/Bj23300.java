package week001.day0925_Deque;

import java.io.*;
import java.util.*;

public class Bj23300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<String> frontwardDeque = new ArrayDeque<>();
        Deque<String> backwardDeque = new ArrayDeque<>();
        String recentPage = null;

        String[] settings = br.readLine().split(" ");

        int lines = Integer.parseInt(settings[1]);

        for (int i = 0; i < lines; i++) {
            String[] command = br.readLine().split(" ");

//            1. 현재 보고 있던 웹페이지를 앞으로 가기 공간에 저장한다.
//            2. 뒤로 가기 공간에서 방문한지 가장 최근의 페이지에 접속한다. 그리고 해당 페이지는 뒤로 가기 공간에서 삭제된다.
            if (command[0].equals("B") && !backwardDeque.isEmpty()) {
                frontwardDeque.offerFirst(recentPage);
                recentPage = backwardDeque.pollLast();
//                1. 현재 보고 있던 페이지를 뒤로 가기 공간에 저장한다.
//                2. 앞으로 가기 공간에서 방문한지 가장 최근의 페이지에 접속한다. 그리고 해당 페이지는 앞으로 가기 공간에서 삭제된다.
            } else if (command[0].equals("F") && !frontwardDeque.isEmpty()) {
                backwardDeque.offerLast(recentPage);
                recentPage = frontwardDeque.pollFirst();
//                1. 앞으로 가기 공간에 저장된 페이지가 모두 삭제된다.
//                2. 현재 페이지를 뒤로 가기 공간에 추가하고, 다음에 접속할 페이지가 현재 페이지로 갱신된다. 단, 처음으로 웹페이지에 접속하는 경우라면 현재 페이지를 뒤로 가기 공간에 추가하지 않는다.
            } else if (command[0].equals("A")) {
                frontwardDeque.clear();

                if (recentPage != null) {
                    backwardDeque.offerLast(recentPage);
                }

                recentPage = command[1];
//                1. 뒤로 가기 공간에서 같은 번호의 페이지가 연속해서 2개 이상 등장할 경우, 가장 최근의 페이지 하나만 남기고 나머지는 모두 삭제한다.
            } else if (command[0].equals("C")) {
                if (!backwardDeque.isEmpty()) {
                    Deque<String> compressedBackwardDeque = new ArrayDeque<>();
                    Iterator<String> iterator = backwardDeque.iterator();

                    String prev = iterator.next();
                    compressedBackwardDeque.offerLast(prev);

                    while (iterator.hasNext()) {
                        String current = iterator.next();
                        if (!current.equals(prev)) {
                            compressedBackwardDeque.offerLast(current);
                        }
                        prev = current;
                    }

                    backwardDeque.clear();
                    backwardDeque.addAll(compressedBackwardDeque);
                }
            }
        }

        StringBuilder backward = new StringBuilder();
        StringBuilder frontward = new StringBuilder();

        if (backwardDeque.isEmpty()) {
            backward.append("-1");
        }

        if (frontwardDeque.isEmpty()) {
            frontward.append("-1");
        }

        while (!backwardDeque.isEmpty()) {
            backward.append(backwardDeque.pollLast()).append(" ");
        }

        if (backward.length() > 0 && backward.charAt(backward.length() - 1) == ' ') {
            backward.setLength(backward.length() - 1);
        }

        while (!frontwardDeque.isEmpty()) {
            frontward.append(frontwardDeque.pollFirst()).append(" ");
        }

        if (frontward.length() > 0 && frontward.charAt(frontward.length() - 1) == ' ') {
            frontward.setLength(frontward.length() - 1);
        }

        bw.write(recentPage + "\n");
        bw.write(backward + "\n");
        bw.write(frontward + "\n");
        bw.flush();
        bw.close();
    }
}
