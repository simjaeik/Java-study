import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] list = {2, 1, 2, 6, 2, 4, 3, 3};
        int N = 5;
        System.out.println(s.solution(N, list));
    }
}

class Solution {
    public ArrayList<Integer> solution(int N, int[] stages) {
        ArrayList<Integer> answer = new ArrayList<>();

        double [] list = new double[N+2];
        for(int n : stages) list[n]++;

        ArrayList<User> ul = new ArrayList<>();

        double size = stages.length;
        for (int i = 1; i <= N; i++) {
            double failure = list[i]/size;

            User u = new User(i,failure);
            ul.add(u);

            size -= list[i];
        }

        Collections.sort(ul);

        for( User u : ul){
            answer.add(u.id);
        }

        return answer;
    }

}

class User implements Comparable<User> {
    int id;
    double failure;


    User(int _id, double _failure){
        id = _id;
        failure = _failure;
    }

    @Override
    public int compareTo(User u){
        if(this.failure < u.failure) return 1;
        else if ( this.failure > u.failure ) return -1;
        return 0;
    }
}
