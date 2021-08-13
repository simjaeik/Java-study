public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(137));
    }
}

class Solution {
    public int solution(int n) {
        int answer = 0;

        int cnt = (int)(Math.log10(n)/Math.log10(3));

        for( int i= cnt; i>=0; i--){
            int num = (int)Math.pow(3, i);
            if(n >= num){
                int div = n / num;
                n -= div*num;

                answer += div*(int)Math.pow(3, cnt-i);
            }
        }

        return answer;
    }
}