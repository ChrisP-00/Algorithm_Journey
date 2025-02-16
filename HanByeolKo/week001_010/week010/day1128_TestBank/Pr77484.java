package week001_010.week010.day1128_TestBank;

public class Pr77484 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int match = 0;
        int zero = 0;

        for (int lotto : lottos) {
            if (lotto == 0) {
                zero++;
                continue;
            }
            for (int win : win_nums) {
                if (lotto == win) {
                    match++;
                }
            }
        }

        int max = calculate(match + zero);
        int min = calculate(match);

        int[] answer = {max, min};

        return answer;
    }

    public static int calculate(int count) {
        return switch (count) {
            case 2 -> 5;
            case 3 -> 4;
            case 4 -> 3;
            case 5 -> 2;
            case 6 -> 1;
            default -> 6;
        };
    }

}
