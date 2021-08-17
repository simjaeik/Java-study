import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] l1 = {46,33,33,8,31,50};
        int[] l2 = {27,56,19,0,14,63};

        System.out.println(s.solution(6,l1,l2));
    }
}

class Solution {
    public ArrayList<String> solution(int n, int[] arr1, int[] arr2) {
        ArrayList<String> answer = new ArrayList<>();

        for(int i=0; i<arr2.length;i++){
            String bit = Integer.toBinaryString(arr1[i] | arr2[i]);

            String sum = bit.replaceAll("0"," ").replaceAll("[12]","#");
            while(sum.length()<n){
                sum = " "+sum;
            }
            answer.add(sum);
        }

        return answer;
    }
}