import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int [] list = {5,2};
        System.out.println(s.solution(list));
    }
}

class Solution {
    public ArrayList<Integer> solution(int[] numbers) {
        ArrayList<Integer> answer = new ArrayList<>();

        HashSet<Integer> s = new HashSet<>();

        int len = numbers.length;
        for(int i=0; i<len-1; i++){
            for(int j=i+1; j<len; j++){
                int sum = numbers[i]+numbers[j];
                s.add(sum);
            }
        }

        for(int n : s){
            answer.add(n);
        }

        Collections.sort(answer);

        return answer;
    }
}
