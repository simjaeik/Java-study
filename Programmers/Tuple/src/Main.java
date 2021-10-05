import java.util.*;

class Solution {
    public int[] solution(String s) {

        s = s.replaceAll("[{}]","");
        String [] list = s.split(",");
        HashMap<Integer, Integer> hs = new HashMap<>();

        for(String ss : list){
            int n = Integer.parseInt(ss);
            hs.put(n, hs.getOrDefault(n, 0)+1);
        }

        List<Map.Entry<Integer, Integer>> entries = new LinkedList<>(hs.entrySet());
        entries.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));

        int[] answer = new int[entries.size()];
        int i=0;
        for(Map.Entry<Integer, Integer> e : entries){
            answer[i++] = e.getKey();
        }

        return answer;
    }
}