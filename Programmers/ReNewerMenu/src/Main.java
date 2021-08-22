import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2, 3, 4};
        System.out.println(s.solution(orders, course));
    }
}

class Solution {

    static HashMap<String, Integer> tm = new HashMap<>();

    public ArrayList<String> solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();

        for (int len : course) {

            for (String data : orders) {
                char[] StringtoChar = data.toCharArray();
                Arrays.sort(StringtoChar);
                data = new String(StringtoChar);
                sol(data, "", 0, len);
            }

            List<Map.Entry<String, Integer>> entries = new LinkedList<>(tm.entrySet());
            Collections.sort(entries, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));

            int max = -1;
            for (Map.Entry<String, Integer> entry : entries) {
                if(entry.getKey().length()!=len) continue;
                if (entry.getValue() >= 2 && max == -1 || max == entry.getValue()) {
                    max = entry.getValue();
                    answer.add(entry.getKey());
                } else break;
            }
        }

        Collections.sort(answer);
        return answer;
    }

    public static void sol(String data, String str, int idx, int len) {
        if (str.length() == len) {
            if (tm.containsKey(str)) tm.put(str, tm.get(str) + 1);
            else tm.put(str, 1);
            return;
        }
        if (str.length() > len) return;

        for (int i = idx; i < data.length(); i++) {
            sol(data, str + data.charAt(i), i + 1, len);
        }
    }
}