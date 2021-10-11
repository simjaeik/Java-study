import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String s = "Hello";
        System.out.println(solution(s.split(""),0));
    }
    public static String solution(String[] s, int n){
        if(n==s.length -1) return s[n];
        return solution(s, n+1)+s[n];
    }
}
