import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        String [] line = sc.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        HashSet<String> hs = new HashSet<>();

        for(int i=0; i<N; i++){
            String str = sc.readLine();
            hs.add(str);
        }

        int cnt =0;
        for(int i=0; i<M; i++){
            String str = sc.readLine();
            if(hs.contains(str)) cnt++;
        }
        System.out.println(cnt);
    }
}
