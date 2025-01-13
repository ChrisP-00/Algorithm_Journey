package week016.day0110_Map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Bj1897 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int d = Integer.parseInt(st.nextToken());
        String start = st.nextToken();

        Set<String> words = new HashSet<>();

        for(int i = 0; i < d; i++){
            words.add(br.readLine());
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        String max = start;

        while(!queue.isEmpty()){
            String word = queue.poll();

            for(int i = 0; i <= word.length(); i++){
                for(char c = 'a'; c <= 'z'; c++){
                    String newWord = word.substring(0,i) + c + word.substring(i);

                    if(words.contains(newWord) && !visited.contains(newWord)){
                        visited.add(newWord);
                        queue.add(newWord);
                        if(newWord.length() > max.length()){
                            max = newWord;
                        }
                    }
                }
            }
        }

        System.out.println(max);
    }
}
