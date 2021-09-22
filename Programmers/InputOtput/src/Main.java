import java.util.*;

class Solution {
    public int[] solution(int[] enter, int[] leave) {
        int[] answer = new int[enter.length];

        ArrayList<Integer> list = new ArrayList();

        int cnt = 0;
        for(int i=0; i<leave.length && cnt < enter.length; i++){
            int cur = leave[i];
            if(list.contains(cur)) continue;

            int input = enter[cnt];
            System.out.println(cur+"-"+input);
            while(input != cur && cnt < enter.length ){
                input = enter[cnt];
                list.add(input);
                cnt++;
            }
            for(int n : list){
                answer[n-1] = list.size()-1;
            }
            list.remove((Integer)cur);
            cnt++;
        }

        return answer;
    }
}