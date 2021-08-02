import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int [] list = {1,2,3,4,5};
        System.out.println(s.solution(list));
    }
}

class Solution {
    public ArrayList<Integer> solution(int[] answers) {

        int[][] person = {{1,2,3,4,5},{2,1,2,3,2,4,2,5},{3,3,1,1,2,2,4,4,5,5}};
        int[] grade = new int[person.length];
        Arrays.fill(grade, 0);

        int max = 0;
        for( int cur = 0; cur<answers.length; cur++ ){
            for(int i=0; i<person.length; i++){
                int idx = cur%person[i].length;
                if(answers[cur] == person[i][idx]){
                    grade[i]++;
                    if(grade[i]>max)
                        max=grade[i];
                }
            }
        }

        ArrayList<Integer> answer = new ArrayList<Integer>();

        for (int i=0; i<grade.length; i++){
            if(grade[i]==max){
                answer.add(i+1);
            }
        }

        return answer;
    }
}