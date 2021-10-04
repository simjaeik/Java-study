import java.util.*;

class Solution {
    public ArrayList<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> ans = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<progresses.length; i++){
            double up = 100-(double)progresses[i];
            int num = (int)Math.ceil(up/(double)speeds[i]);
            q.add(num);
        }

        int prev = q.poll();
        int cnt = 1;
        while(q.size()>0){
            int cur = q.poll();

            if(prev >= cur){
                cnt++;
                continue;
            }

            ans.add(cnt);
            prev = cur;
            cnt = 1;
        }
        ans.add(cnt);

        return ans;
    }
}