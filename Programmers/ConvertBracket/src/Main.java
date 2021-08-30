import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.solution("()))((()"));
    }
}

class Solution {
    public String solution(String p) {
        return sol(p);
    }

    public static String sol(String str) {
        if (str.equals("")) return str;

        int[] cmp = {0, 0};
        String u = "", v = "";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') cmp[0]++;
            else cmp[1]++;

            if (cmp[0] == cmp[1]) {
                u = str.substring(0, i + 1);
                v = str.substring(i + 1);
                break;
            }
        }

        Stack<Character> st = new Stack<>();
        st.push(u.charAt(0));

        if (u.charAt(0) == '(') {

            int i = 1;
            boolean right = true;
            for (; i < u.length(); i++) {
                char cur = u.charAt(i);
                if (cur == ')' && st.empty()) right = false;

                if (cur == '(') st.push(cur);
                else st.pop();
            }
            if (right) return u + sol(v);

        }

        String ans = "(" + sol(v) + ")";

        for (int j = 1; j < u.length() - 1; j++) {
            if (u.charAt(j) == ')') ans += "(";
            else ans += ")";
        }

        return ans;
    }
}