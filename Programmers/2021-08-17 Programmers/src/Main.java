import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        SortMyString s = new SortMyString();

        String [] list = {"abce", "abcd", "cdx"};
        System.out.println(s.solution(list, 2));
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

class SumBetweenTwoNums {
    public long solution(int a, int b) {
        long answer = 0;

        for(int i = a; i<=b; i++) answer+=i;

        return answer;
    }
}

class SortMyString {
    public ArrayList<String> solution(String[] strings, int n) {
        ArrayList<String> answer = new ArrayList<>();

        for(String s : strings) answer.add(s);

        Collections.sort(answer, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if( o1.charAt(n) > o2.charAt(n)) return 1;
                else if (o1.charAt(n) < o2.charAt(n)) return -1;
                return o1.compareTo(o2);
            }
        });

        return answer;
    }
}