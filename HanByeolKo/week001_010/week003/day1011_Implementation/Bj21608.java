package week001_010.week003.day1011_Implementation;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Bj21608 {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    private static int[][] seats;

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

        seats = new int[row][row];

        for (int k = 1; k < students; k++) {
            List<int[]> temp = new ArrayList<>();
            boolean isEmpty;
            int maxfirstScore = 0;

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < row; j++) {
                    int std = i * (row - 1);
                    int idx = i + j + std;
                    isEmpty = seats[i][j] == 0;

                    if (idx == 0) {
                        seats[1][1] = lists.get(0).get(0);
                    }

                    if (isEmpty) {
                        int firstScore = search(i, j, lists.get(k).subList(1, 5));

                        if (firstScore > maxfirstScore) {
                            maxfirstScore = firstScore;
                            temp.clear();
                            temp.add(new int[]{i, j});
                        } else if (firstScore == maxfirstScore) {
                            temp.add(new int[]{i, j});
                        }
                    }
                }
            }

            int nextX = -1;
            int nextY = -1;
            int maxEmpty = -1;
            for (int[] seat : temp) {
                if (countEmpty(seat[0], seat[1]) > maxEmpty) {
                    maxEmpty = countEmpty(seat[0], seat[1]);
                    nextX = seat[0];
                    nextY = seat[1];
                }
            }

            seats[nextX][nextY] = lists.get(k).get(0);
        }

        int result = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                int std = seats[i][j];
                int listIndex = -1;
                for (int k = 0; k < lists.size(); k++) {
                    if (lists.get(k).get(0) == std) {
                        listIndex = k;
                        break;
                    }
                }
                if (listIndex != -1) {
                    result += finalScore(i, j, lists.get(listIndex).subList(1, 5));
                }
            }
        }

        br.close();
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

    public static int search(int x, int y, List<Integer> friend) {
        int newX;
        int newY;
        int friendScore = 0;

        for (int i = 0; i < 4; i++) {
            newX = x + dx[i];
            newY = y + dy[i];

            if (newX >= 0 && newY >= 0 && newX < seats.length && newY < seats[0].length) {
                if (friend.contains(seats[newX][newY])) {
                    friendScore++;
                }
            }
        }

        return friendScore;
    }

    public static int countEmpty(int x, int y) {
        int emptyCount = 0;
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX >= 0 && newY >= 0 && newX < seats.length && newY < seats[0].length) {
                if (seats[newX][newY] == 0) {
                    emptyCount++;
                }
            }
        }
        return emptyCount;
    }

    public static int finalScore(int x, int y, List<Integer> friend) {
        int friendScore = search(x, y, friend);
        int score = 0;

        if (friendScore == 1) {
            score = 1;
        } else if (friendScore == 2) {
            score = 10;
        } else if (friendScore == 3) {
            score = 100;
        } else if (friendScore == 4) {
            score = 1000;
        }

        return score;
    }
}
