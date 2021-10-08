import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        String[] line = sc.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        String word = sc.readLine();
        String wordLine = sc.readLine();

        HashMap<Character, Integer> cmp = new HashMap<>();
        HashMap<Character, Integer> hs = new HashMap<>();

        for(int i=0; i<N; i++){
            char cur = word.charAt(i);
            cmp.put(cur, cmp.getOrDefault(cur,0)+1);
            cur = wordLine.charAt(i);
            hs.put(cur, hs.getOrDefault(cur,0)+1);
        }

        int answer =0;
        if(equalHash(cmp, hs)) answer++;

        for(int i=1; i<=M-N; i++){
            char prev = wordLine.charAt(i-1);
            char cur = wordLine.charAt(i+N-1);
            hs.put(prev, hs.get(prev)-1);
            hs.put(cur, hs.getOrDefault(cur,0)+1);

            if(equalHash(cmp, hs)) answer++;
        }
        System.out.println(answer);
    }

    public static boolean equalHash(HashMap<Character, Integer> cur, HashMap<Character, Integer> cmp){

        for(Map.Entry<Character, Integer> entry : cur.entrySet()){
            if(!entry.getValue().equals(cmp.get(entry.getKey()))) return false;
        }
        return true;
    }
}
