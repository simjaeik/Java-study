import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String [] list = {"N~F=0", "R~T>2"};

        System.out.println(s.solution(2,list));
    }
}

class Solution {
    static int n;
    static String[] data;
    static char [] fr = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static HashMap<Character, String> hs = new HashMap<>();

    public int solution(int n, String[] data) {

        for(int i=0; i<8; i++) hs.put(fr[i], Integer.toString(i));

        Solution.n = n;
        Solution.data = data;

        boolean [] chk = new boolean[8];

        return sol(0, chk, "");
    }

    public static int sol(int idx, boolean[] used, String s){
        if(idx>=8){
            if(validData(s)) return 1;
            return 0;
        }

        int sum = 0;
        for(int i=0; i<8; i++){
            if(used[i]) continue;
            used[i] = true;
            sum += sol(idx+1, used, s+i);
            used[i] = false;
        }

        return sum;
    }

    private static boolean validData(String s) {
        for(String str : data){
            int first = s.indexOf(hs.get(str.charAt(0)));
            int second = s.indexOf(hs.get(str.charAt(2)));
            char cmd = str.charAt(3);
            int num = str.charAt(4)-'0';

            if(cmd=='='){
                if(Math.abs(first-second)!=num+1) return false;
            }
            else if (cmd == '>'){
                if(Math.abs(first-second)<=num+1) return false;
            }else if (cmd =='<'){
                if(Math.abs(first-second)>=num+1) return false;
            }
        }
        return true;
    }
}