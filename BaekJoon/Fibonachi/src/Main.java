import java.io.*;
import java.util.*;

public class Main {
    static int [][] d = new int[41][2];

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(sc.readLine());
        d[0] = new int[]{1, 0};
        d[1] = new int[]{0, 1};

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(sc.readLine());
            getString(num);
        }
        sc.close();
    }
    public static void getString(int N){
        if(N<=1) {
            System.out.println(d[N][0]+" "+d[N][1]);
            return;
        }
        for(int i=2; i<=N; i++){
            d[i][0] = d[i-2][0] + d[i-1][0];
            d[i][1] = d[i-2][1] + d[i-1][1];
        }
        System.out.println(d[N][0]+" "+d[N][1]);
    }
}