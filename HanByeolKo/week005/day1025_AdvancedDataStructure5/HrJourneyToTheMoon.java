package week005.day1025_AdvancedDataStructure5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {
    public static long journeyToMoon(int n, List<List<Integer>> astronaut) {
        // Write your code here
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (List<Integer> integers : astronaut) {
            int temp = integers.get(0);
            int temp2 = integers.get(1);

            if (!list.get(temp).contains(temp2)) {
                list.get(temp).add(temp2);
            }
            if (!list.get(temp2).contains(temp)) {
                list.get(temp2).add(temp);
            }
        }

        boolean[] visited = new boolean[n];
        List<Integer> group = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                int size = dfs(i,list,visited);
                group.add(size);
            }
        }

        int totalAstronauts = n;
        long result = 0;

        for (int size : group) {
            totalAstronauts -= size;
            result += (long) size * totalAstronauts;
        }

        return result;

    }

    private static int dfs(int astronaut, List<List<Integer>> adjacencyList, boolean[] visited) {
        visited[astronaut] = true;
        int size = 1;

        for (int neighbor : adjacencyList.get(astronaut)) {
            if (!visited[neighbor]) {
                size += dfs(neighbor, adjacencyList, visited);
            }
        }

        return size;
    }
}

public class HrJourneyToTheMoon {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int p = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> astronaut = new ArrayList<>();

        IntStream.range(0, p).forEach(i -> {
            try {
                astronaut.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        long result = Result.journeyToMoon(n, astronaut);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
