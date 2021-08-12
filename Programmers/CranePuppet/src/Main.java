import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] b = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] m = {1, 5, 3, 5, 1, 2, 1, 4};
        System.out.println(s.solution(b, m));
    }
}

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> st = new Stack<>();

        int len = board.length;
        for (int n : moves) {
            n--;
            for (int i = 0; i < len; i++) {
                int cur = board[i][n];
                if (cur!=0){
                    board[i][n]=0;
                    if (!st.empty() && cur == st.peek()) {
                        st.pop();
                        answer+=2;
                    } else {
                        st.push(cur);
                    }
                    break;
                }
            }
        }

        return answer;
    }
}