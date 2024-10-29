package week006.day1029_Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj26070 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int Z = Integer.parseInt(st.nextToken());

        long result = 0;
        result += Math.min(A,X);
        result += Math.min(B,Y);
        result += Math.min(C,Z);

        int remainChickenTicket = Math.max(X - A,0);
        int remainPizzaTicket = Math.max(Y - B,0);
        int remainHamburgerTicket = Math.max(Z - C,0);

        int remainChickenStudent = Math.max(A-X,0);
        int remainPizzaStudent = Math.max(B-Y,0);
        int remainCHamburgerStudent = Math.max(C-Z,0);

        while (remainChickenTicket >= 3 || remainPizzaTicket >= 3 || remainHamburgerTicket >= 3) {
            if (remainChickenTicket >= 3) {
                remainPizzaTicket += changeTicket(remainChickenTicket);
                if(remainPizzaStudent > 0){
                    if(remainPizzaTicket - remainPizzaStudent >= 0) {
                        result += remainPizzaStudent;
                        remainPizzaTicket -= remainPizzaStudent;
                        remainPizzaStudent = 0;
                    }else {
                        result += remainPizzaTicket;
                        remainPizzaStudent -= remainPizzaTicket;
                        remainPizzaTicket = 0;
                    }
                }
                remainChickenTicket = noChangeTicket(remainChickenTicket);
            }

            if (remainPizzaTicket >= 3) {
                remainHamburgerTicket += changeTicket(remainPizzaTicket);
                if (remainCHamburgerStudent > 0) {
                    if(remainHamburgerTicket >= remainCHamburgerStudent) {
                        result += remainCHamburgerStudent;
                        remainHamburgerTicket -= remainCHamburgerStudent;
                        remainCHamburgerStudent = 0;
                    }else {
                        result += remainHamburgerTicket;
                        remainCHamburgerStudent -= remainHamburgerTicket;
                        remainHamburgerTicket = 0;
                    }
                }
                remainPizzaTicket = noChangeTicket(remainPizzaTicket);
            }

            if (remainHamburgerTicket >= 3) {
                remainChickenTicket += changeTicket(remainHamburgerTicket);
                if (remainChickenStudent > 0) {
                    if(remainChickenTicket - remainChickenStudent >= 0) {
                        result += remainChickenStudent;
                        remainChickenTicket -= remainChickenStudent;
                        remainChickenStudent = 0;
                    }else {
                        result += remainChickenTicket;
                        remainChickenStudent -= remainChickenTicket;
                        remainChickenTicket = 0;
                    }
                }
                remainHamburgerTicket = noChangeTicket(remainHamburgerTicket);
            }
        }

        System.out.println(result);
    }

    private static int changeTicket(int remain) {
        return remain / 3;
    }

    private static int noChangeTicket(int remain) {
        return remain % 3;
    }
}
