import java.util.*;
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{50,82,75,120}, new String[]{"NLWL","WNLL","LWNW","WWLN"}));
    }
}

class Solution {
    public int[] solution(int[] weights, String[] head2head) {
        int[] answer = new int[weights.length];
        ArrayList<Box> list = new ArrayList<>();

        for(int i=0; i<weights.length; i++){
            Box tmp = new Box(weights[i], i+1);
            list.add(tmp);
        }

        for(int i=0; i<head2head.length; i++){
            Box tmp = list.get(i);
            String str = head2head[i];
            double cnt = 0;
            for(int j = 0; j<str.length(); j++){
                if(i == j) continue;
                if(str.charAt(j)!='N') cnt++;
                if(str.charAt(j) == 'W') {
                    tmp.win++;
                    if(weights[i] < weights[j]) tmp.heavyWin++;
                }
            }
            tmp.winRate = tmp.win/cnt;
        }
        Collections.sort(list);

        for(int i =0; i<list.size();i++){
            answer[i] = list.get(i).num;
        }
        return answer;
    }

    public class Box implements Comparable<Box>{
        double win = 0;
        double winRate;
        int heavyWin = 0;
        int weight;
        int num;

        Box(int weight, int num){
            this.weight = weight;
            this.num = num;
        }

        @Override
        public int compareTo( Box b){
            if(this.winRate > b.winRate) return -1;
            else if (this.winRate < b.winRate ) return 1;

            if(this.heavyWin > b.heavyWin) return -1;
            else if (this.heavyWin < b.heavyWin) return 1;

            if(this.weight > b.weight) return -1;
            else if (this.weight < b.weight) return 1;

            if(this.num > b.num) return 1;
            else return -1;
        }
    }
}