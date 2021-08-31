import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(sc.readLine());

        for(int i=0; i<N; i++){
            String[] line = sc.readLine().split(" ");
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            long dis = y-x;

            long a = (int)Math.sqrt(dis);
            if(dis==a*a) System.out.println(2*a-1);
            else if (a*a<dis && dis <=a*a+a) System.out.println(2*a);
            else System.out.println(2*a+1);
        }
    }
}
