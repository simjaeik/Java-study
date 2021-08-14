public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] list = {1,2,7,6,4};
        System.out.println(s.solution(list));
    }
}

class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        int len = nums.length;
        for(int i=0; i<len-2; i++){
            int sum = 0;
            for(int j = i+1; j<len-1; j++){
                for(int k = j+1; k<len; k++){
                    sum = nums[i]+nums[j]+nums[k];
                    boolean prime = true;
                    for(int a = 3; a<=sum/2; a++){
                        if(sum%a==0){
                            prime = false;
                            break;
                        }
                    }
                    if(prime)
                      answer++;
                }
            }
        }

        return answer;
    }
}
