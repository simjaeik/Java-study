import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int [] list = {1,3,2,5,4};
        int bud = 9;

        System.out.println(s.solution(list, bud));
    }
}

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);

        for (int n : d) {
            if (budget - n < 0) break;
            budget -= n;
            answer++;
        }

        return answer;
    }
}