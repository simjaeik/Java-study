import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(1, 2));
    }
}

class Solution {
    public int solution(int left, int right) {
        int answer = 0;

        for(int num = left; num<=right; num++){
            int cnt = getDivideCount(num);
            if(cnt%2==0){
                answer+=num;
            }
            else{ 
                answer-=num;
            }
        }

        return answer;
    }

    public int getDivideCount(int num){
        int answer = 1;

        int len = num/2;
        for(int i = 2; i<=len; i++){
            int top = 0;
            while(num%i==0 && num > 1){
                num /= i;
                top++;
            }
            answer *= top+1;
            if(num <= 1 ) break;
        }
        if(num!=1 && answer==1)
            return 2;

        return answer;
    }
}