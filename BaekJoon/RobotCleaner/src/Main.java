import java.util.*;
import java.io.*;

public class Main {

    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[][] m;
    static int N;
    static int M;
    static int cz = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader s = new BufferedReader(new InputStreamReader(System.in));

        String[] line = s.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        line = s.readLine().split(" ");
        int r = Integer.parseInt(line[0]);
        int c = Integer.parseInt(line[1]);
        int d = Integer.parseInt(line[2]);

        m = new int[N][M];

        for (int i = 0; i < N; i++) {
            line = s.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                m[i][j] = Integer.parseInt(line[j]);
            }
        }

        System.out.println(solv(0, r, c, d));
    }

    public static int solv(int cnt, int x, int y, int pos) {
        if (m[x][y] == 0) {
            m[x][y] = 2;
            cnt++;
        }

        int cur = pos;
        for (int i = 0; i < 4; i++) {
            int ncur = (cur + 3) % 4;
            int nx = x + dir[ncur][0];
            int ny = y + dir[ncur][1];
            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
            if (m[nx][ny] == 0) {
                cnt = solv(cnt, nx, ny, ncur);
                return cnt;
            }
            cur = (cur + 3) % 4;
        }

        int back = (pos + 2) % 4;
        int bx = x + dir[back][0];
        int by = y + dir[back][1];

        if (m[bx][by] != 1) cnt = solv(cnt, bx, by, pos);
        return cnt;
    }
}