import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] list = {{100, 90, 98, 88, 65}, {50, 45, 99, 85, 77}, {47, 88, 95, 80, 67}, {61, 57, 100, 80, 65}, {24, 90, 94, 75, 65}};

        System.out.println(s.solution(list));
    }
}

class Solution {
    public String solution(int[][] scores) {
        StringBuilder answer = new StringBuilder();

        int len = scores.length;
        for(int i=0; i<len; i++){
            int me = scores[i][i];
            ArrayList<Integer> list = new ArrayList<>();

            for(int j =0; j<len; j++){
                int cur = scores[j][i];
                list.add(cur);
            }
            Collections.sort(list);

            if(list.get(0)==me){
                if(list.get(1)!=me) {
                    list.remove(0);
                }
            }
            else if(list.get(len-1)==me){
                if(list.get(len-2)!=me){
                    list.remove(len-1);
                }
            }

            int sum =0;
            for(int n : list){
                sum+=n;
            }
            int result = sum/list.size();

            if(result >= 90)
                answer.append("A");
            else if(result >= 80)
                answer.append("B");
            else if(result >= 70)
                answer.append("C");
            else if(result >= 50)
                answer.append("D");
            else
                answer.append("F");
        }

        return answer.toString();
    }
}