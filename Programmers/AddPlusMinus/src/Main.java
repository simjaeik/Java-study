public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] abs = {1,3,2};
        boolean[] sings = {true, false, false};

        System.out.println(s.solution(abs, sings));
    }
}

class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for (int i=0; i<absolutes.length; i++){
            int num = absolutes[i];
            if(!signs[i])
                num*=-1;
            answer+=num;
        }

        return answer;
    }
}