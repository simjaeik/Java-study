import java.util.*;

public class InputOutput {
    public static void main(String[] args) {
        Solution a = new Solution();

        System.out.println(a.solution(new int[]{1,4,2,3},new int[]{2,1,3,4}));
    }
}

class Solution {
    public int[] solution(int[] enter, int[] leave) {
        int[] answer = new int[enter.length];

        ArrayList<Integer> list = new ArrayList();
        ArrayList<HashSet<Integer>> hs = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<=enter.length; i++) {
            hs.add(i, new HashSet<>());
            if(i!=enter.length)
                q.add(enter[i]);
        }

        for (int cur : leave) {
            if(q.isEmpty()) break;
            else if(list.contains(cur)) {
                list.remove((Integer)cur);
                continue;
            }

            int qq = q.poll();
            while (qq != cur && !q.isEmpty()) {
                list.add(qq);
                qq = q.poll();
            }
            list.add(qq);

            for (int j = 0; j < list.size(); j++) {
                for (int k = 0; k < list.size(); k++) {
                    if (j == k) continue;
                    hs.get(list.get(j)).add(list.get(k));
                }
            }

            list.remove((Integer) cur);
        }

        for(int i=0; i<enter.length; i++) answer[i] = hs.get(i+1).size();

        return answer;
    }
}
//
//class Solution {
//    public int[] solution(int[] enter, int[] leave) {
//        int len = enter.length;
//        int[] answer = new int[len], idx = new int[len + 1];
//        for(int i = 0; i < len; i++) idx[enter[i]] = i;
//        for(int i = 0; i < len; i++) {
//            for(int j = 0, late = idx[enter[i]]; j < len; j++) {
//                int e = enter[i], l = leave[j];
//                if(e == l) break;
//                if(idx[l] > late || (late > idx[e] && idx[l] < late)) {
//                    answer[l-1]++;
//                    answer[e-1]++;
//                    late = Math.max(idx[l], late);
//                }
//            }
//        }
//        return answer;
//    }
//}