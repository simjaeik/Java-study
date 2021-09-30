class Solution {
    static int[] list;
    static int t;
    public int solution(int[] numbers, int target) {

        list = numbers;
        t = target;
        int answer = dfs(0, 0);

        return answer;
    }

    public int dfs(int cnt, int sum){
        if(cnt==list.length){
            if(sum==t){
                return 1;
            }
            return 0;
        }

        return dfs(cnt+1, sum+list[cnt]) + dfs(cnt+1, sum-list[cnt]);
    }
}