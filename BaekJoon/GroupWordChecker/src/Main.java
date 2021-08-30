import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        sc.nextLine();
        int answer =0;
        for(int i=0; i<N;i++){
            String str = sc.nextLine();
            answer += checker(str);
        }

        System.out.print(answer);
        sc.close();
    }

    static int checker(String str){
        HashSet<Character> hs = new HashSet<>();

        hs.add(str.charAt(0));
        for(int i=1; i<str.length();i++){
            char cur = str.charAt(i);
            if(hs.contains(cur) && str.charAt(i-1) != cur) return 0;
            hs.add(cur);
        }
        return 1;
    }
}
