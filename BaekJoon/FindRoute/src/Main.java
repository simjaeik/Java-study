import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(sc.readLine());
        int[][] d = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] tok = sc.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                d[i][j] = Integer.parseInt(tok[j]);
            }
        }
        sc.close();

        for(int k = 0; k<N; k++){
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(d[i][k] + d[k][j] == 2) d[i][j] = 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int[] line : d){
            for(int n : line) sb.append(n+" ");
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
