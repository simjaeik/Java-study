import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        NoSameName s = new NoSameName();

        int [] list = {1,1,2,3,3,4,2,3,1,1,0,0,2,1};
        System.out.println(s.solution(list));
    }
}

class MidChar {
    public String solution(String s) {
        String answer = "";

        int len = s.length();

        if (len % 2 == 0) {
            answer += s.substring(len / 2 - 1, len / 2 + 1);
        } else {
            answer += s.charAt(len / 2);
        }

        return answer;
    }
}

class Dart {
    public int solution(String dartResult) {
        int answer = 0;

        ArrayList<Integer> list = new ArrayList<>();

        int n = 0;
        for (int i = 0; i < dartResult.length(); i++) {
            char c = dartResult.charAt(i);

            if (c >= '0' && c <= '9') {
                n = n * 10 + (c - '0');
            } else if (c == 'S' || c == 'D' || c == 'T') {
                int num;
                num = (c == 'S') ? 1 : (c == 'D') ? 2 : 3;
                list.add((int) Math.pow(n, num));
                n = 0;
            } else if (c == '*') {
                int last = list.size() - 1;
                if (!list.isEmpty()) {
                    list.set(last-1, list.get(last-1) * 2);
                }
                list.set(last, list.get(last) * 2);
                n = 0;
            } else if (c == '#') {
                int last = list.size() - 1;
                list.set(last, list.get(last) * (-1));
                n = 0;
            }
        }

        for (int a : list)  {
            System.out.println(a);
            answer += a;
        }

        return answer;
    }
}
class NoSameName {
    public ArrayList<Integer> solution(int []arr) {
        ArrayList<Integer> answer = new ArrayList<>();

        int prev = -1;
        for(int n : arr){
            if(prev!=n) answer.add(n);
            prev=n;
        }

        return answer;
    }
}

class DivableArr {
    public ArrayList<Integer> solution(int[] arr, int divisor) {
        ArrayList<Integer> answer = new ArrayList<>();

        for(int n : arr){
            if(n%divisor==0) answer.add(n);
        }

        Collections.sort(answer);

        if(answer.isEmpty()) answer.add(-1);
        return answer;
    }
}