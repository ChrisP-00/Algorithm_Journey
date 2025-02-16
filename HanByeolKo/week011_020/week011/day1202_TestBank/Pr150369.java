package week011_020.week011.day1202_TestBank;

class Pr150369 {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        int d = 0;
        int p = 0;

        for(int i = n-1; i >= 0; i--){
            int count = 0;

            d -= deliveries[i];
            p -= pickups[i];

            while (d < 0 || p < 0){
                d += cap;
                p += cap;
                count++;
            }

            answer += (i + 1) * 2 * count;
        }

        return answer;
    }
}
