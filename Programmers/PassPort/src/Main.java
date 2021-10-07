import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 1000000000;

        Arrays.sort(times);

        long start = times[0];
        long end = start * n;

        while(start <= end){
            long mid = (start+end)/2;
            long curNum = mid;
            long count =0;
            for(int i=0; i<times.length; i++){
                count += mid/times[i];
                if(count > n){
                    if((start == end) && (answer > mid)){
                        answer = mid;
                    }
                    end = mid-1;
                    break;
                }
            }
            if(count < n){
                start = mid+1;
            }else if(count==n){
                answer = mid;
                end = mid-1;
            }
        }

        return answer;
    }

}