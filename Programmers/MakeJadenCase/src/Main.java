import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("3sadf23   asdf4 JKJKJKff123 2 "));
    }
}
class Solution {
    public StringBuilder solution(String s) {
        StringBuilder answer = new StringBuilder();
        String [] tok = s.toLowerCase().split("");

        boolean flag = true;
        for(String str : tok){
            String tmp = flag ? str.toUpperCase() : str;
            answer.append(tmp);
            flag = str.equals(" ");
        }

        return answer;
    }
}