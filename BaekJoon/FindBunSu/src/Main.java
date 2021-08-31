import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();

        System.out.println(solution(N));
    }

    static String solution(long N){

        long n = 0;
        long res = 0;
        while(true){
            long cur = (n*(n+1));
            if(cur >= 2*N){
                res = (cur/2) - N;
                if(n % 2 == 0) return (n-res)+"/"+(1+res);
                else return (1+res)+"/"+(n-res);
            }
            n++;
        }
    }
}
