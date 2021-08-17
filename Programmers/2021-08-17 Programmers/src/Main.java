import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.solution("1S2D*3T"));
    }
}

class MidChar {
    public String solution(String s) {
        String answer = "";

        int len = s.length();

        if (len % 2 == 0) {
            answer += s.substring(len / 2 - 1, len / 2 + 1);
        } else {
            answer += s.charAt(len / 2);
        }

        return answer;
    }
}

class Solution {
    public int solution(String dartResult) {
        int answer = 0;

        ArrayList<Integer> list = new ArrayList<>();

        int n = 0;
        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);

            if (c >= '0' && c <= '9') {
                n = n * 10 + (c - '0');
            } else if (c == 'S' || c == 'D' || c == 'T') {
                int num;
                num = (c == 'S') ? 1 : (c == 'D') ? 2 : 3;
                list.add((int) Math.pow(n, num));
                n = 0;
            } else if (c == '*') {
                int last = list.size() - 1;
                if (!list.isEmpty()) {
                    list.set(last-1, list.get(last-1) * 2);
                }
                list.set(last, list.get(last) * 2);
                n = 0;
            } else if (c == '#') {
                int last = list.size() - 1;
                list.set(last, list.get(last) * (-1));
                n = 0;
            }
        }

        for (int a : list)  {
            System.out.println(a);
            answer += a;
        }

        return answer;
    }
}