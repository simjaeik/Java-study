import java.util.*;
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("EIO"));
    }
}

class Solution {
    public int solution(String word) {
        int answer = 0;

        HashMap<Character, Integer> hs = new HashMap<>();
        hs.put('A',0);
        hs.put('E',1);
        hs.put('I',2);
        hs.put('O',3);
        hs.put('U',4);

        int[] nums = {781, 156, 31, 6, 1};
        for(int i=0, len = word.length(); i<len; i++){
            char c = word.charAt(i);
            int multi = hs.get(c);

            answer += nums[i]*multi +1;
        }

        return answer;
    }
}