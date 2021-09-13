public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(15, 2));
    }
}

class Solution {
    public int solution(int n, int k) {
        int answer = 0;

        String num = convertDecimal(n,k);
        String[] nums = num.split("0");

        for(String number : nums){
            if(number.equals("")) continue;
            long cur = Long.parseLong(number);
            if(isPrime(cur)) answer++;
        }

        return answer;
    }

    public boolean isPrime(long num) {
        if(num == 0 || num == 1) return false;
        if(num == 2) return true;
        if(num%2 == 0) return false;
        for(long i = 3; i<=(long)Math.sqrt(num); i+=2){
            if(num%i == 0) return false;
        }
        return true;
    }

    public String convertDecimal(int num, int decimal){
        StringBuilder ans = new StringBuilder();
        while(num > 0){
            ans.insert(0, (num % decimal));
            num /= decimal;
        }
        return ans.toString();
    }
}