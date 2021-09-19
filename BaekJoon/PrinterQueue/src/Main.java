import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(s.readLine());
        int target = 0;

        for(int i=0; i<N; i++){
            String[] line = s.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            target = Integer.parseInt(line[1]);

            ArrayList<Integer> list = new ArrayList<>();
            Queue<Print> li = new LinkedList<>();

            line = s.readLine().split(" ");
            for( int j =0; j<n;j++){
                int num = Integer.parseInt(line[j]);
                list.add(num);
                li.add(new Print(j, num));
            }
            Collections.sort(list, Comparator.reverseOrder());

            int cur = -1;
            int idx = 0;
            while(cur!=target){
                Print p = li.poll();

                if(p.val == list.get(idx)){
                    cur = p.num;
                    idx++;
                }else{
                    li.add(p);
                }
            }
            System.out.println(idx);
        }
    }

    public static class Print{
        int num;
        int val;

        Print(int num, int val){
            this.num = num;
            this.val = val;
        }
    }
}
