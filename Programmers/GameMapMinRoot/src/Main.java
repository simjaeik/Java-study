import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] map = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        System.out.println(s.solution(map));
    }
}

class Solution {

    static int [][] dir = {{0,1},{1,0},{0,-1}, {-1,0}};
    static int n, m;

    public int solution(int[][] maps) {

        m = maps.length;
        n = maps[0].length;

//        PriorityQueue<int[]> pq = new PriorityQueue<>(( o1, o2) -> o1[2] - o2[2]);
        Queue<int[]> pq = new LinkedList<>();

        pq.add(new int []{0,0,1});
        maps[0][0] = 0;

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int x = cur[0];
            int y = cur[1];
            int dis = cur[2];

            if(isGoal(cur)) return dis;

            for(int i=0; i<dir.length; i++){
                int nx = x + dir[i][0];
                int ny = y + dir[i][1];
                if(nx<0 || nx>=m || ny<0 || ny>=n || maps[nx][ny] == 0 ) continue;

                pq.add(new int[]{nx, ny, dis+1});
                maps[nx][ny] = 0;
            }
        }

        return -1;
    }

    static boolean isGoal (int[] cur){
        return cur[0] == m-1 && cur[1] == n-1;
    }

}