import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new String[]{"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"},
                new String[]{"PYTHON", "C++", "SQL"}, new int[]{7, 5, 5}));
    }
}

class Solution {
    public String solution(String[] table, String[] languages, int[] preference) {

        String ans = "ZZZZZZZZ";
        TreeMap<String, TreeMap<String, Integer>> hs = new TreeMap<>();

        for (String line : table) {
            String[] tok = line.split(" ");
            String name = tok[0];

            TreeMap<String, Integer> tmp = new TreeMap<>();
            for (int i = 1; i < tok.length; i++) {
                tmp.put(tok[i], 6 - i);
            }
            hs.put(name, tmp);
        }

        int max = 0;

        for (String company : hs.keySet()) {
            int score = 0;
            for (int i = 0; i < languages.length; i++) {
                String lang = languages[i];
                int pref = preference[i];

                if (!hs.get(company).containsKey(lang)) continue;
                score += hs.get(company).get(lang) * pref;
            }
            if (max < score || (max == score && company.compareTo(ans) < 0)) {
                max = score;
                ans = company;
            }
        }

        return ans;
    }
}