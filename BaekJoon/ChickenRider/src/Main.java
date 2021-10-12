import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        String[] line = sc.readLine().split(" ");
        int N = stoi(line[0]);
        int M = stoi(line[1]);

        int[][] grid = new int[N][N];
        List<int[]> chickenList = new ArrayList<>();
        List<int[]> houseList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            line = sc.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                grid[i][j] = stoi(line[j]);
                if (grid[i][j] == 2) chickenList.add(new int[]{i, j});
                else if (grid[i][j] == 1) houseList.add(new int[]{i, j});
            }
        }

        System.out.println(solution(0, 0, M, new ArrayList<>(), chickenList, houseList));
    }

    public static int solution(int count,int idx, int M, List<int[]> selected, List<int[]> chickenList, List<int[]> houseList) {
        if (count == M ) {
            return getDistance(selected, houseList);
        } else if(idx >= chickenList.size()){
            return 100000;
        }

        List<int[]> curSeleceted = new ArrayList<>(selected);

        int result1 = solution(count, idx+1, M, curSeleceted, chickenList, houseList);
        curSeleceted.add(chickenList.get(idx));
        int result2 = solution(count+1,idx+1, M, curSeleceted, chickenList, houseList);
        return Math.min(result1, result2);
    }

    public static int getDistance(List<int[]> selected, List<int[]> houseList) {
        int answer =0;
        for (int[] house : houseList) {
            int min = 10000;
            for (int[] chicken : selected) {
                int distance = Math.abs(chicken[0] - house[0]) + Math.abs(chicken[1] - house[1]);
                min = Math.min(distance, min);
            }
            answer+=min;
        }
        return answer;
    }

    public static int stoi(String str) {
        return Integer.parseInt(str);
    }
}
