import java.util.HashMap;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.solution("E=M*C^2","e=m*c^2"));
    }
}
class Solution {
    public int solution(String str1, String str2) {

        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        HashMap<String, Integer> hs = new HashMap<>();
        double g = 0, h = 0;
        int a1 = 0, a2 = 0;

        // 2개씩 끊어서 배열 만들기
        for(int i=0; i<str1.length()-1; i++){
            String tok = str1.substring(i, i+2);
            if(tok.matches("(.*)[^a-zA-Z](.*)")) continue;
            hs.put(tok, hs.getOrDefault(tok,0)+1);
            h++;
            a1++;
        }

        for(int i=0; i<str2.length()-1; i++){
            String tok = str2.substring(i, i+2);
            if(tok.matches("(.*)[^a-zA-Z](.*)")) continue;
            a2++;

            if(hs.containsKey(tok)){
                g++;
                int val = hs.get(tok);
                hs.put(tok, val-1);
                if(val == 1) hs.remove(tok);
            }else {
                h++;
            }
        }

        // 두 개를 비교하면서 교집합, 합집합 만들기
        // 교집합용, 합집합용 map 만들기
        // 두 번째 배열을 읽으면서 이미 존재하면 map에 -1하고, 교집합에 추가, 합집합에는 0 이하면 추가

        if( a1+a2 == 0) return 65536;

        Double ans =(g/h)*65536;
        return ans.intValue();
    }
}