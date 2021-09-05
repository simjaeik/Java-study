import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(sc.readLine())-1;

        String tmp = Integer.toString(N) + "666";
        int ans = Integer.parseInt(tmp);

        System.out.println(ans);
    }
}
