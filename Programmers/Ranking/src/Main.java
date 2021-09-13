public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}));
    }
}
class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;

        boolean[][] chk = new boolean[n][n];

        for(int[] line : results) chk[line[0]-1][line[1]-1] = true;

        for(int k = 0; k<n; k++){
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    if(chk[i][k] && chk[k][j]) chk[i][j] = true;
                }
            }
        }

        for(int i=0; i<n; i++){
            int cnt=0;
            for(int j=0; j<n; j++){
                if(chk[i][j] || chk[j][i]) cnt++;
            }
            if(cnt == n-1) answer++;
        }

        return answer;
    }
}