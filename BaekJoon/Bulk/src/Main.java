import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(sc.readLine());

        ArrayList<int[]> list = new ArrayList<>();

        for(int i=0; i<N; i++){
            String[] line = sc.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            list.add(new int[]{x,y});
        }

        for(int i=0; i<N;i++){
            int cnt = 1;
            int [] cur = list.get(i);
            for(int j =0; j<N; j++){
               if(i==j) continue;
               int [] cmp = list.get(j);
                if(cur[0] < cmp[0] && cur[1] < cmp[1]) cnt++;
            }
            System.out.print(cnt+" ");
        }

    }
}
