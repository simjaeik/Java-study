import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static char [][] B = new char[8][8];
    static char [][] W = new char[8][8];

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        String [] fl = sc.readLine().split(" ");
        int N = Integer.parseInt(fl[0]);
        int M = Integer.parseInt(fl[1]);

        char [][] ch = new char [N][M];

        initBW();

        for(int i=0; i<N;i++){
            String line = sc.readLine();
            for(int j=0; j<M;j++){
                char c = line.charAt(j);
                ch[i][j] = c;
            }
        }

        int min = N*M+1;
        for(int i=0; i <= N-8; i++){
            for(int j = 0; j <= M-8; j++){
                min = Math.min(min, findMin(i,j,ch));
            }
        }

        System.out.println(min);
    }
    static int findMin(int x, int y, char[][] ch){

        int minB = 0, minW = 0;
        for(int i=x; i<x+8; i++){
            for(int j = y; j < y+8; j++){
                if(B[i-x][j-y]!=ch[i][j]) minB++;
                if(W[i-x][j-y]!=ch[i][j]) minW++;
            }
        }
        return Math.min(minB,minW);
    }

    static void initBW(){
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if((i+j)%2==0) {
                    B[i][j] = 'B';
                    W[i][j] = 'W';
                }
                else{
                    B[i][j] = 'W';
                    W[i][j] = 'B';
                }
            }
        }
    }
}
