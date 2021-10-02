public class Main {
}
class Solution {
    int solution(int[][] land) {
        int answer = 0;

        int row = land.length;
        int col = land[0].length;


        for(int i=1; i<row; i++){
            int maxNum = 0, prevMax = 0;
            int maxIdx = 0;
            for(int k =0; k<col; k++){
                int cur = land[i-1][k];
                if(maxNum <= cur){
                    prevMax = maxNum;
                    maxNum = cur;
                    maxIdx = k;
                }
                else if(prevMax <= cur){
                    prevMax = cur;
                }
            }

            for(int j=0; j<col; j++){
                if(maxIdx != j) land[i][j] += maxNum;
                else land[i][j] += prevMax;
            }
        }

        int max =0;
        for(int n : land[row-1]){
            max = Math.max(n, max);
        }

        return max;
    }
}