import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        String[] line = sc.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int L = Integer.parseInt(line[1]);

        ArrayList<int[]> li = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            line = sc.readLine().split(" ");
            int n1 = Integer.parseInt(line[0]);
            int n2 = Integer.parseInt(line[1]);

            li.add(new int[]{n1, n2});
        }
        li.sort((l1, l2) -> l1[0] - l2[0]);

        int start = 0;
        int ans = 0;
        for (int[] l : li) {
            if(start >= l[1]) continue;
            start = Math.max(start, l[0]);
            int cnt = (int) Math.ceil((double)(l[1] - start) / L);
            ans += cnt;
            start += (cnt * L);
        }
        System.out.println(ans);
    }
}
