import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};

        System.out.println(s.solution(info, query));
    }
}

class Solution {
    public ArrayList<Integer> solution(String[] info, String[] query) {
        ArrayList<Integer> answer = new ArrayList<>();

        ArrayList<Man> list = new ArrayList<>();

        for(String line : info){
            list.add(new Man(line));
        }

        Collections.sort(list);

        for(String line : query){
            int cnt = 0;
            int num = Integer.parseInt(line.replaceAll("[^0-9]",""));
            for(int i=0; i<list.size(); i++){
                Man cur = list.get(i);
                if(num > cur.score) break;
                if(cur.checkValid(line)) cnt++;
            }
            answer.add(cnt);
        }

        return answer;
    }

    public class Man implements Comparable<Man>{
        String[] conditions = new String[4];
        int score;

        Man(String line){
            String[] token = line.split(" ");
            for(int i=0; i<4;i++) this.conditions[i] = token[i];
            this.score = Integer.parseInt(token[4]);
        }

        boolean checkValid(String cmd){
            String[] token = cmd.split(" and ");
            for(int i=0; i<3;i++){
                if(token[i].equals("-")) continue;
                if(!token[i].equals(this.conditions[i])) return false;
            }

            String[] last = token[3].split(" ");
            int sc = 0;

            if(last.length==2) {
                if(!last[0].equals("-") && !last[0].equals(this.conditions[3])) return false;
                sc = Integer.parseInt(last[1]);
            }else{
                sc =  Integer.parseInt(last[0]);
            }

            return sc <= this.score;
        }

        @Override
        public int compareTo(Man o) {
            return o.score - this.score;
        }
    }
}