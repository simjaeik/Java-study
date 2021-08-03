import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int [] nums = {1,2,3,3,2,4};
        System.out.println(s.solution(nums));
    }
}

class Solution {
    public int solution(int[] nums) {
        int answer = nums.length/2;

        HashSet<Integer> hs = new HashSet<Integer>();

        for ( int n : nums){
            hs.add(n);
        }

        if(hs.size() < answer){
            answer = hs.size();
        }

        return answer;
    }
}