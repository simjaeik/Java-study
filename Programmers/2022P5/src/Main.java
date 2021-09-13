import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1}, new int[][]{{0, 1}, {1, 2}, {1, 4}, {0, 8}, {8, 7}, {9, 10}, {9, 11}, {4, 3}, {6, 5}, {4, 6}, {8, 9}}));
    }
}

class Solution {
    public int solution(int[] info, int[][] edges) {
        int answer = 0;

        HashMap<Integer, Node> hs = new HashMap<>();
        for(int i =0; i<info.length; i++){
            Node tmp = new Node(i, info[i]);
            hs.put(i, tmp);
        }

        for(int [] ary : edges){
            Node parent = hs.get(ary[0]);
            Node child = hs.get(ary[1]);

            parent.getNext(child);
        }

        return answer;
    }

    public class Node {
        int number;
        boolean isSheep;
        ArrayList<Node> next = null;

        Node() {
        }

        Node(int number, int sheepOrWolf) {
            this.number = number;
            this.isSheep = sheepOrWolf == 0;
        }

        public void getNext(Node node) {
            if (next.isEmpty()) {
                this.next = new ArrayList<>();
            }
            this.next.add(node);
        }

    }
}