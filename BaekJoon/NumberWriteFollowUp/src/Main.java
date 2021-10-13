import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String line = sc.readLine();
        int len = line.length();
        long N = Long.parseLong(line);

        if( len == 1 ) {
            System.out.println(N);
            return;
        }

        long answer = 0;
        for(int i=1; i<=len-1; i++){
            answer += 9*Math.pow(10, i-1)*i;
        }
        answer += (N - Math.pow(10, len-1) + 1) * len;
        System.out.println(answer);
    }
}
