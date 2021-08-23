import java.awt.color.ICC_Profile;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] list = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        System.out.println(s.solution(list));
    }
}

class Solution {
    public int[] solution(String[] gems) {

        int left = 0;
        int right = 0;

        HashMap<String, Integer> hs = new HashMap<>();

        for (String g : gems) {
            hs.put(g, hs.getOrDefault(g, 0) + 1);
        }

        HashMap<String, Integer> h = new HashMap<>();
        h.put(gems[0], 1);

        int[] ans = {0, 0};
        int min = 100001;
        int goal = hs.size();
        int k = 1;

        while (left <= right && right < gems.length && left < gems.length) {
            if (k < goal) {
                right++;
                if(right >= gems.length) break;
                h.put(gems[right], h.getOrDefault(gems[right], 0) + 1);
            } else if (k == goal) {
                int gap = right - left;
                if (min > gap) {
                    ans[0] = left;
                    ans[1] = right;
                    min = gap;
                    if (gap == goal-1) break;
                }
                if(h.get(gems[left])==1) h.remove(gems[left]);
                else h.put(gems[left], h.get(gems[left]) - 1);
                left++;
                if(left >= gems.length) break;
            }
            k = h.size();
        }

        System.out.println(ans[0] + "-" + ans[1]);
        return new int[]{left + 1, right + 1};
    }
}