import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(9, new int[]{0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1}));
    }
}

class Solution {
    static int N;
    static int[] list;
    static int ans = 0;
    static int[] ansList = new int[]{-1};
    static int lion;

    public int[] solution(int n, int[] info) {
        N = n;
        list = info;

        for(int i =0; i<info.length; i++){
            if(info[i]>0) lion+= 10-i;
        }

        getMax(0, 0, new int[11], 0 );

        return ansList;
    }

    public void getMax(int idx, int cnt, int[] ary, int sum){
        if(idx >= 11) {
            int gap = sum - lion;
            if( cnt >= N || gap >= ans){
                if(gap >= ans && gap > 0){
                    int[] tmp = ary.clone();
                    tmp[10] = ary[10]+N-cnt;
                    if(gap == ans ) {
                        if(myCompareTo(tmp)) ansList = tmp.clone();
                        else return;
                    }
                    ansList = tmp.clone();
                    ans = gap;
                }
            }
            return;
        }

        int hitNow = cnt + list[idx]+1;
        if( hitNow <= N ) {
            ary[idx] = list[idx] + 1;
            if(list[idx] > 0) lion -= 10-idx;
            getMax(idx+1, hitNow, ary, sum+10-idx);
            if(list[idx] > 0) lion += 10-idx;
        }
        ary[idx] = 0;
        getMax(idx+1, cnt, ary, sum);
    }

    public static boolean myCompareTo(int[] cmp){
        if(ansList[0]==-1) return true;
        String str1 = "";
        String str2 = "";

        for(int i=10; i>=0; i--){
            str1+=cmp[i];
            str2+=ansList[i];
        }
        return str1.compareTo(str2) > 0;
    }

}