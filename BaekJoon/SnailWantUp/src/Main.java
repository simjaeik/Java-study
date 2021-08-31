import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        String[] line = sc.readLine().split(" ");
        int A = Integer.parseInt(line[0]);
        int B = Integer.parseInt(line[1]);
        int V = Integer.parseInt(line[2]);

        V -= A;
        int div = A-B;

        if(V%div == 0) System.out.println(V/div + 1);
        else System.out.println(V/div+2);
    }
}
