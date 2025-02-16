package week001_010.week003.day1008_DivideAndConquer;

import java.io.*;

public class Bj11582 {
    private static int[] arr;
    private static int person;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int chicken = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        arr = new int[chicken];

        for (int i = 0; i < chicken; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        person = Integer.parseInt(br.readLine());

        mergeSort(0, chicken - 1);

        for (int i = 0; i < chicken; i++) {
            bw.write(arr[i] + " ");
        }

        bw.flush();
        bw.close();
    }

    public static void mergeSort(int startIdx, int endIdx){
        if (startIdx < endIdx) {
            int midIdx = (startIdx + endIdx) / 2;
            mergeSort(startIdx, midIdx);
            mergeSort(midIdx + 1, endIdx);
            merge(startIdx, midIdx, endIdx);
        }
    }

    public static void merge(int startIdx, int midIdx, int endIdx) {
        int[] temp = new int[endIdx - startIdx + 1];

        // 새로만들 배열의 크기가 치킨집을 사람수로 나눈 것보다 크면 그만해
        if(temp.length > arr.length / person){
            return;
        }
        // 배열 두동강의 왼쪽거 시작인덱스
        int i = startIdx;
        // 배열 두동강의 오른쪽거 시작인덱스
        int j = midIdx + 1;
        // 정렬해서 들어갈 새 배열의 인덱스
        int k = 0;

        // 두동강 다 남았을때
        while (i <= midIdx && j <= endIdx) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // 마지막이 왼동강만 남았을 때
        while (i <= midIdx) {
            temp[k++] = arr[i++];
        }

        // 마지막이 오른동강만 남았을때
        while (j <= endIdx) {
            temp[k++] = arr[j++];
        }

        // 배열을 정렬된 걸로 복사해오기
        for (int index = startIdx; index <= endIdx; index++) {
            // index가 startIdx부터 시작해서 temp에서는 startIdx 빼야 0부터 ++ 된다
            arr[index] = temp[index - startIdx];
        }
    }
}