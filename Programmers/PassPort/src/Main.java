import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);

        return sol(times, (long)n, times[0], (long) times[0] * n);
    }

    public static long sol(int[] times, long n, long start, long end) {

        if (start == end) {
            return start;
        }
        long mid = (start + end) / 2;
        long count = 0;
        for (int time : times) {
            count += mid / time;
            if(count > n){
                return sol(times, n, start, mid );
            }
        }

        if (count < n) {
            return sol(times, n, mid + 1, end);
        } else {
            return sol(times, n, start, mid );
        }
    }
}