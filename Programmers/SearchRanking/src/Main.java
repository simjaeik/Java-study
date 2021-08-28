import java.sql.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};

        System.out.println(s.solution(info, query));
    }
}

class Solution {
    static TreeMap<String, ArrayList<Integer>> hs = new TreeMap<>();

    public ArrayList<Integer> solution(String[] info, String[] query) {
        ArrayList<Integer> answer = new ArrayList<>();

        ArrayList<Man> list = new ArrayList<>();

        getHashMap(info);

        Collections.sort(list);

        for (String line : query) {
            String [] token = line.split(" ");
            String [] tok = {token[0], token[2], token[4], token[6]};
            int target = Integer.parseInt(token[7]);

            String str = getStr(tok);

            ArrayList<Integer> li = hs.get(str);
            Collections.sort(li);

            answer.add(getCount(li, target, 0, li.size()-1));
        }

        return answer;
    }

    public int getCount(ArrayList<Integer> li, int target, int left, int right){
        int mid = (left+right)/2;

        int cur = li.get(mid);

        if(left > right) {
            return mid+1;
        }
        else if(cur <= target){
            return getCount(li, target, mid+1, right);
        }
        else {
            return getCount(li, target, left, mid-1);
        }

    }

    public void getHashMap(String[] info) {
        for (String line : info) {
            String[] token = line.split(" ");
            String str = getStr(token);
            int num = Integer.parseInt(token[4]);

            allSynario("", str, 0, num);
        }
    }

    public void allSynario(String cur, String str, int idx, int num){
        if(idx==str.length()){
            if (!hs.containsKey(cur)) {
                hs.put(cur, new ArrayList<>());
            }
            hs.get(cur).add(num);
            return;
        }

        allSynario(cur+"-", str, idx+1, num);
        allSynario(cur+str.charAt(idx), str, idx+1, num);

    }

    public String getStr(String [] token){
        String ans = "";
        String str = token[0];
        if(str.equals("java")) ans+="j";
        else if(str.equals("python")) ans+="p";
        else if (str.equals("cpp")) ans+="c";
        else ans+="-";

        str = token[1];
        if(str.equals("backend")) ans+="b";
        else if (str.equals("frontend")) ans+="f";
        else ans+="-";

        str = token[2];
        if(str.equals("junior")) ans+="j";
        else if (str.equals("senior")) ans+="s";
        else ans+="-";

        str = token[3];
        if(str.equals("pizza")) ans+="p";
        else if(str.equals("chicken")) ans+="c";
        else ans+="-";

        return ans;
    }

    public class Man implements Comparable<Man> {
        String[] conditions = new String[4];
        int score;

        Man(String line) {
            String[] token = line.split(" ");
            for (int i = 0; i < 4; i++) this.conditions[i] = token[i];
            this.score = Integer.parseInt(token[4]);
        }

        boolean checkValid(String cmd) {
            String[] token = cmd.split(" and ");
            for (int i = 0; i < 3; i++) {
                if (token[i].equals("-")) continue;
                if (!token[i].equals(this.conditions[i])) return false;
            }

            String[] last = token[3].split(" ");
            int sc = 0;

            if (last.length == 2) {
                if (!last[0].equals("-") && !last[0].equals(this.conditions[3])) return false;
                sc = Integer.parseInt(last[1]);
            } else {
                sc = Integer.parseInt(last[0]);
            }

            return sc <= this.score;
        }

        @Override
        public int compareTo(Man o) {
            return o.score - this.score;
        }
    }
}