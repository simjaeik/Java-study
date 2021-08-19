import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        Solution s = new Solution();
        s.solution(N,sc);
        sc.close();
    }
}

class Solution{
    public void solution(int N, Scanner sc){

        for(int i=0; i<N; i++){
            int n = sc.nextInt();

            int [] list = new int[n];

            double sum = 0;
            for(int j=0; j<n; j++){
                list[j]=sc.nextInt();
                sum += list[j];
            }

            double avg = sum/(double)n;

            double cnt = 0;
            for( int num : list){
                if(num > avg) cnt++;
            }

            System.out.println(String.format("%.3f%%",(cnt/n)*100));
        }
        sc.close();
    }
}


