import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("323   4 123 2 "));
    }
}
class Solution {
    public StringBuilder solution(String s) {
        StringBuilder answer = new StringBuilder();
        String [] tok = s.toLowerCase().split(" ");

        for(String str : tok){
            if(str.equals("")) {
                answer.append(" ");
                continue;
            }
            String tmp = str.substring(0,1).toUpperCase() + str.substring(1) + " ";
            answer.append(tmp);
        }
        if(s.charAt(s.length()-1) != ' ')
            answer.deleteCharAt(answer.length()-1);

        return answer;
    }
}