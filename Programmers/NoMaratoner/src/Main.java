import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        String [] list = {"leo", "kiki", "eden"};
        String [] go = {"leo", "eden"};

        System.out.println(s.solution(list, go));
    }
}

class Solution {
    public String solution(String[] participant, String[] completion) {

        HashMap<String, Integer> s = new HashMap<>();

        for(String par : completion){
            if(s.containsKey(par)){
                s.put(par, s.get(par)+1);
            }
            else{
                s.put(par, 1);
            }
        }

        String answer = "";
        for (String man : participant){
            if(!s.containsKey(man) || s.get(man) == 0){
                answer = man;
                break;
            }
            s.put(man, s.get(man)-1);
        }

        return answer;
    }
}

// getOrDeault 사용한 경우
//
//class Solution {
//    public String solution(String[] participant, String[] completion) {
//        String answer = "";
//        HashMap<String, Integer> hm = new HashMap<>();
//        for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
//        for (String player : completion) hm.put(player, hm.get(player) - 1);
//
//        for (String key : hm.keySet()) {
//            if (hm.get(key) != 0){
//                answer = key;
//            }
//        }
//        return answer;
//    }
//}
