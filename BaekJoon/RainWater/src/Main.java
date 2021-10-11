import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        String[] line = sc.readLine().split(" ");
        int H = toInt(line[0]);
        int W = toInt(line[1]);

        int[][] blocks = new int[H][W];

        line = sc.readLine().split(" ");
        for (int i = 0; i < W; i++) {
            int num = toInt(line[i]);
            for (int j = num-1; j >= 0; j--) blocks[j][i] = 1;
        }

        int answer = 0;
        for (int i = 0; i < H; i++) {
            boolean blockPassed = false;
            int blockCount = 0;
            for (int block : blocks[i]) {
                if (block == 1) {
                    if (!blockPassed) {
                        blockPassed = true;
                        blockCount = 0;
                        continue;
                    }
                    answer += blockCount;
                    blockCount = 0;
                } else {
                    blockCount++;
                }
            }
        }
        System.out.println(answer);
    }

    public static int toInt(String str) {
        return Integer.parseInt(str);
    }
}
