import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int [][] q = {{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}};

        System.out.println(s.solution(3, 3, q));
    }
}

class Solution {
    public ArrayList<Integer> solution(int rows, int columns, int[][] queries) {
        ArrayList<Integer> answer = new ArrayList<>();

        int [][] m = initMatrix(rows, columns);

        for(int [] list : queries) {
            int [] l1 = {list[0]-1, list[1]-1};
            int [] l2 = {list[2]-1, list[3]-1};

            int min = rows*columns+1;

            // ->
            int prev = m[l1[0]+1][l1[1]];
            for(int i = l1[1]; i<=l2[1]; i++){
                if(prev<min) min = prev;
                int j = l1[0];

                int tmp = m[j][i];
                m[j][i] = prev;
                prev= tmp;
            }

            // 밑
            for(int i = l1[0]+1; i<=l2[0]; i++){
                if(prev<min) min = prev;
                int j = l2[1];

                int tmp = m[i][j];
                m[i][j] = prev;
                prev = tmp;
            }

            // <-
            for(int i = l2[1]-1; i>=l1[1]; i--){
                if(prev<min) min = prev;
                int j = l2[0];

                int tmp = m[j][i];
                m[j][i] = prev;
                prev = tmp;
            }

            // 위
            for(int i = l2[0]-1; i>=l1[0]; i--){
                int j = l1[1];
                if(prev<min) min = prev;

                int tmp = m[i][j];
                m[i][j] = prev;
                prev = tmp;
            }

         answer.add(min);
        }

        return answer;
    }

    public static int [][] initMatrix(int rows, int columns){
        int [][] matrix = new int[rows][columns];
        int num = 1;
        for (int i=0; i<rows; i++){
            for(int j =0; j<columns; j++){
                matrix[i][j]=num++;
            }
        }
        return matrix;
    }
}
