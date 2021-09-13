import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[][]{{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}}, new int[][]{{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}}));
    }
}

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;

        Arrays.sort(skill, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                StringBuilder str1= new StringBuilder();
                StringBuilder str2= new StringBuilder();
                for(int i=1; i<=4; i++){
                    str1.append(o1[i]);
                    str2.append(o2[i]);
                }
                return str1.compareTo(str2);
            }
        });

        for(int i=0; i<board.length; i++){
            int [] line = board[i];
            for(int j=0; j<line.length; j++){

            }
        }

        for(int[] line : board){
            for(int n : line){
                if( n > 0) answer++;
            }
        }

        return answer;
    }
}