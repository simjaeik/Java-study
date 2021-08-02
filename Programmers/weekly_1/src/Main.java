public class Main {
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.solution(3,20,4));
    }
}

class Solution {
    public long solution(int price, int money, int count) {

        long sum = 0;
        for (long i=1; i<=count; i++){
            sum+=price*i;
        }

        long answer = money - sum;
        if(answer>0)
            return 0;

        return Math.abs(answer);
    }
}