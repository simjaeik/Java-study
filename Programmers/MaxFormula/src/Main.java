import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("100-200*300-500+20"));
    }
}

class Solution {
    public long solution(String expression) {
        String[] list = {"+-*", "+*-", "*+-", "*-+", "-*+", "-+*"};
        long[] nums = Arrays.stream(expression.split("[^0-9]")).mapToLong(Long::parseLong).toArray();

        ArrayList<Character> cmd = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            char s = expression.charAt(i);
            if (s == '+' || s == '*' || s == '-') cmd.add(s);
        }

        long max = 0;
        for (String s : list) {
            ArrayList<Character> cmdd = new ArrayList<>(cmd);
            long [] numss = new long[nums.length];
            for( int i =0; i<nums.length; i++){
                numss[i] = nums[i];
            }

            long sum = getSum(cmdd, numss, s);
            max = Math.max(max, sum);
        }

        return max;
    }

    static long getSum(ArrayList<Character> cmd, long[] nums, String list) {

        for (int i = 0; i < 3; i++) {
            char c = list.charAt(i);
            Stack<Long> st = new Stack<>();

            st.add(nums[0]);
            int j = 0;
            for (int n = 0; n<cmd.size(); j++) {
                long num;
                if (cmd.get(n)== c) {
                    num = calc(c, st.pop(), nums[j + 1]);
                    cmd.remove(n);
                } else {
                    num = nums[j + 1];
                    n++;
                }
                st.add(num);
            }

            long [] tmp = new long [st.size()];

            int len = st.size();
            for (int s = len - 1; s >= 0; s--) {
                tmp[s] = st.pop();
            }

            nums = tmp;
        }

        return Math.abs(nums[0]);
    }

    static long calc(char cmd, Long a, Long b) {
        if (cmd == '+') return a + b;
        else if (cmd == '-') return a - b;
        else if (cmd == '*') return a * b;
        return 0;
    }
}