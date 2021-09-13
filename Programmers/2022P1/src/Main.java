import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        String[] l1 = {"muzi", "frodo", "apeach", "neo"};
        String[] l2 = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};

        System.out.println(s.solution(l1, l2, 2));
    }
}

class Solution {
    static int K;
    public ArrayList<Integer> solution(String[] id_list, String[] report, int k) {
        ArrayList<Integer> answer = new ArrayList<>();
        K = k;
        HashMap<String, User> hs = new HashMap<>();

        for(String name : id_list){
            hs.put(name, new User(name));
        }

        for(String line : report){
            String[] tok = line.split(" ");

            String rep = tok[0];
            String reported = tok[1];

            User repUser = hs.get(rep);
            User reportedUser = hs.get(reported);

            if(repUser.isDup(reported)) continue;

            repUser.report(reportedUser);
            reportedUser.reported();
        }

        for(String name : id_list){
            User cur = hs.get(name);
            answer.add(cur.getReported());
        }

        return answer;
    }

    public class User{
        String name;
        int report = 0;
        HashMap<String,User> list = new HashMap<>();

        User(){};
        User(String name){
            this.name = name;
        }

        public boolean isDup(String who) {
            return list.containsKey(who);
        }

        public void report(User who){
            this.list.put(who.name, who);
        }

        public void reported(){
            this.report++;
        }

        public int getReported(){
            int cnt = 0;
            for(Map.Entry<String, User> entry : list.entrySet()){
                User cur = entry.getValue();
                if(cur.report >= K) cnt++;
            }
            return cnt;
        }
    }
}