import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution a = new Solution();
        int[] a1 = {1, 3, 4};
        int[] a2 = {1,3,5};

        System.out.println(a.solution(5, a1, a2));
    }
}

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int idx = 0;
        int answer = n - lost.length;

        for (int num : reserve){
            int find = Arrays.binarySearch(lost, num);
            if(idx >= lost.length){
                break;
            }
            if(find>=0){
                idx = find+1;
                answer++;
                continue;
            }

            while(idx < lost.length && num+1 >= lost[idx]){
                if(Math.abs(num-lost[idx])==1){
                    answer++;
                    idx++;
                    break;
                }
                idx++;
            }
        }

        return answer;
    }
}

// 다른사람 풀이

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] people = new int[n];
        int answer = n;

        for (int l : lost)
            people[l-1]--;
        for (int r : reserve)
            people[r-1]++;

        for (int i = 0; i < people.length; i++) {
            if(people[i] == -1) {
                if(i-1>=0 && people[i-1] == 1) {
                    people[i]++;
                    people[i-1]--;
                }else if(i+1< people.length && people[i+1] == 1) {
                    people[i]++;
                    people[i+1]--;
                }else
                    answer--;
            }
        }
        return answer;
    }
}