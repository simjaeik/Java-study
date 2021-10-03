import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = -1;

        Stack<Character> stk = new Stack<>();
        stk.push(s.charAt(0));

        for(int i=1; i<s.length(); i++){
            char ss = s.charAt(i);

            if(stk.empty()) {
                stk.push(ss);
                continue;
            }

            char top = stk.peek();
            if(ss==top){
                stk.pop();
            }
            else{
                stk.push(ss);
            }
        }

        return stk.empty() ? 1 : 0;
    }
}