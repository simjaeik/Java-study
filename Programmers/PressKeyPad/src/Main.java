import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int [] list = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};

        System.out.println(s.solution(list, "right"));
    }
}

class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        HashMap<Integer, int[]> list = new HashMap<>();
        int [] left = {3, 0};
        int [] right = {3, 2};

        int [] zero = {3,1};
        list.put(0, zero);
        for(int i=1; i<=9; i++){
            int [] tmp = {(i-1)/3, (i-1)%3};
            list.put(i, tmp);
        }

        for( int num : numbers){
            int [] cur = list.get(num);
            int l = getRange(left, cur);
            int r = getRange(right, cur);

            if( num == 1 || num == 4 || num == 7){
                answer.append("L");
                left = cur;
            }
            else if ( num == 3 || num == 6 || num == 9){
                answer.append("R");
                right = cur;
            }
            else if( l > r ) {
                answer.append("R");
                right = cur;
            }
            else if ( l < r) {
                answer.append("L");
                left = cur;
            }
            else {
                if(hand.equals("right")){
                    answer.append("R");
                    right = cur;
                }
                else{
                    answer.append("L");
                    left = cur;
                }
            }
        }

        return answer.toString();
    }

    public int getRange(int[] hand, int[] key){
        return Math.abs(hand[0]-key[0])+Math.abs(hand[1]-key[1]);
    }
}
//
//class Solution {
//    //        0부터 9까지 좌표 {y,x}
//    int[][] numpadPos = {
//            {3,1}, //0
//            {0,0}, //1
//            {0,1}, //2
//            {0,2}, //3
//            {1,0}, //4
//            {1,1}, //5
//            {1,2}, //6
//            {2,0}, //7
//            {2,1}, //8
//            {2,2}  //9
//    };
//    //초기 위치
//    int[] leftPos = {3,0};
//    int[] rightPos = {3,2};
//    String hand;
//    public String solution(int[] numbers, String hand) {
//        this.hand = (hand.equals("right")) ? "R" : "L";
//
//        String answer = "";
//        for (int num : numbers) {
//            String Umji = pushNumber(num);
//            answer += Umji;
//
//            if(Umji.equals("L")) {leftPos = numpadPos[num]; continue;}
//            if(Umji.equals("R")) {rightPos = numpadPos[num]; continue;}
//        }
//        return answer;
//    }
//
//    //num버튼을 누를 때 어디 손을 사용하는가
//    private String pushNumber(int num) {
//        if(num==1 || num==4 || num==7) return "L";
//        if(num==3 || num==6 || num==9) return "R";
//
//        // 2,5,8,0 일때 어디 손가락이 가까운가
//        if(getDist(leftPos, num) > getDist(rightPos, num)) return "R";
//        if(getDist(leftPos, num) < getDist(rightPos, num)) return "L";
//
//        //같으면 손잡이
//        return this.hand;
//    }
//
//    //해당 위치와 번호 위치의 거리
//    private int getDist(int[] pos, int num) {
//        return Math.abs(pos[0]-numpadPos[num][0]) + Math.abs(pos[1]-numpadPos[num][1]);
//    }
//}