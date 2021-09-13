import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
    }
}

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;

        boolean[] pass = new boolean[n + 1];

        HashMap<Integer, Node> hs = new HashMap<>();

        for (int i = 1; i <= n; i++) hs.put(i, new Node(i));

        for (int[] line : edge) {
            Node n1 = hs.get(line[0]);
            Node n2 = hs.get(line[1]);

            n1.putNext(n2);
            n2.putNext(n1);
        }

        Queue<Integer> q = new LinkedList<>();
        Node head = hs.get(1);
        head.grade = 1;
        pass[1] = true;
        q.add(head.num);

        int prev = 0;
        int cnt = 0;
        while (!q.isEmpty()) {
            Node cur = hs.get(q.poll());

            if(prev!=cur.grade) {
                answer = cnt;
                cnt=0;
                prev = cur.grade;
            }
            ArrayList<Node> next = cur.getNextNode();
            for (Node nd : next) {
                int curNum = nd.num;
                if (!pass[curNum]) {
                    nd.grade = cur.grade+1;
                    q.add(curNum);
                    pass[curNum] = true;
                    cnt++;
                }
            }

        }

        return answer;
    }

    public class Node {
        int num;
        int grade;
        ArrayList<Node> next = new ArrayList<>();

        Node() {
        }

        Node(int num) {
            this.num = num;
        }

        public void putNext(Node next) {
            this.next.add(next);
        }

        public ArrayList<Node> getNextNode() {
            return this.next;
        }
    }
}
