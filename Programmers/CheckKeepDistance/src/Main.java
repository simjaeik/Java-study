import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[][] list = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        System.out.println(s.solution(list));
    }
}
//
//class Solution {
//    static ArrayList<int[]> list;
//
//    public ArrayList<Integer> solution(String[][] places) {
//        ArrayList<Integer> answer = new ArrayList<>();
//
//        for (String[] room : places) {
//
//            list = new ArrayList<>();
//            char[][] info = getRoomInfo(room);
//
//            boolean isValid = true;
//            for(int i=0; i<list.size()-1; i++){
//                int[] p = list.get(i);
//                if(!validJogun(p, info, i)) {
//                    isValid = false;
//                    break;
//                }
//            }
//
//            if (isValid) answer.add(1);
//            else answer.add(0);
//        }
//
//        return answer;
//    }
//
//    static boolean validJogun(int[] cur, char[][] room, int cnt){
//
//        for(int n = cnt+1; n<list.size(); n++){
//            int [] cmp = list.get(n);
//            int dis = getDistance(cur,cmp);
//
//            if(dis > 2) break;
//            if(dis == 1) return false;
//
//            if(cur[0]==cmp[0]){
//                for(int i = cur[1]; i<cmp[1]; i++){
//                    if(room[cur[0]][i] =='O') return false;
//                }
//            }
//            else if (cur[1]==cmp[1]){
//                for(int i= cur[0]; i<cmp[0]; i++){
//                    if(room[i][cur[1]]=='O') return false;
//                }
//            }
//            else{
//                int mov = (cur[1] > cmp[1]) ? -1 : 1;
//                if(room[cur[0]][cur[1]+mov]=='O' || room[cur[0]+1][cur[1]]=='O') return false;
//            }
//        }
//        return true;
//    }
//
//    static int getDistance(int[] a, int[] b){
//        return Math.abs(a[0]-b[0])+Math.abs(a[1]-b[1]);
//    }
//
//    static char[][] getRoomInfo(String[] room) {
//
//        char[][] ans = new char[5][5];
//        int a = 0;
//        for (String line : room) {
//            char[] tmp = new char[5];
//            for (int i = 0; i < line.length(); i++) {
//                tmp[i] = line.charAt(i);
//                if(tmp[i]=='P') list.add(new int[]{a,i});
//            }
//            ans[a++] = tmp;
//        }
//        return ans;
//    }
//}


class Solution {

    static ArrayList<int[]> sit;
    final static int [][] dir = {{0,1},{1,0},{0,-1}};

    public ArrayList<Integer> solution(String[][] places) {
        ArrayList<Integer> ans = new ArrayList<>();

        for(String [] r : places){
            sit = new ArrayList<>();
            char [][] room = getRoomInfo(r);

            boolean isValid = true;
            for(int[] man : sit){
                boolean [][] chk = new boolean[5][5];
                chk[man[0]][man[1]] = true;
                if(!checkValid(man, room, 2, chk)) {
                    isValid = false;
                    break;
                }
            }
            if(isValid) ans.add(1);
            else ans.add(0);
        }
        return ans;
    }

    static boolean checkValid(int[] man, char[][] room, int count, boolean[][] chk){
        if(count != 2 && room[man[0]][man[1]]=='P') return false;
        if(count==0){
            return true;
        }

        for(int i=0; i<dir.length; i++){
            int x = man[0]+dir[i][0];
            int y = man[1]+dir[i][1];
            if(x < 0 || y < 0 || x >= room.length || y >= room.length || chk[x][y] || room[x][y] == 'X') continue;
            chk[man[0]][man[1]] = true;
            if(!checkValid(new int[]{x,y}, room, count-1, chk)) return false;
            chk[man[0]][man[1]] = false;
        }
        return true;
    }

    static char[][] getRoomInfo(String[] room) {
        char[][] ans = new char[5][5];
        int a = 0;
        for (String line : room) {
            char[] tmp = new char[5];
            for (int i = 0; i < line.length(); i++) {
                tmp[i] = line.charAt(i);
                if(tmp[i]=='P') sit.add(new int[]{a,i});
            }
            ans[a++] = tmp;
        }
        return ans;
    }
}