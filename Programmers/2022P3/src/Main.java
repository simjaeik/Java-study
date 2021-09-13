import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(new int[]{1, 461, 1, 10},
                new String[]{"00:00 1234 IN"}));
    }
}

class Solution {
    public ArrayList<Integer> solution(int[] fees, String[] records) {
        ArrayList<Integer> answer = new ArrayList<>();
        TreeMap<String, Car> map = new TreeMap<String, Car>();

        for (String line : records) {
            String[] tok = line.split(" ");
            String time = tok[0];
            String carNum = tok[1];
            String cmd = tok[2];

            Car car;
            if (!map.containsKey(carNum)) {
                car = new Car(time);
                map.put(carNum, car);
                continue;
            }

            car = map.get(carNum);

            if (cmd.equals("IN")) {
                car.in(time);
            } else if (cmd.equals("OUT")) {
                car.out(time);
            }
        }

        for (Map.Entry<String, Car> entry : map.entrySet()) {
            Car car = entry.getValue();
            answer.add(car.payMoney(fees));
        }

        return answer;
    }

    public class Car {
        int time = 0;
        int in = 0;
        boolean outCheck = true;

        Car() {
        }

        Car(String in) {
            this.in = converTime(in);
            this.outCheck = false;
        }

        public int converTime(String t) {
            String[] tok = t.split(":");
            return Integer.parseInt(tok[0]) * 60 + Integer.parseInt(tok[1]);
        }

        public void in(String in) {
            this.in = converTime(in);
            this.outCheck = false;
        }

        public void out(String out) {
            int outTime = converTime(out);

            time += outTime - in;
            in = 0;
            this.outCheck = true;
        }

        public int payMoney(int[] fees) {
            int basicTime = fees[0], basicFee = fees[1], unitTime = fees[2], unitFee = fees[3];

            if (!this.outCheck) {
                time += 23 * 60 + 59 - in;
            }

            int payTime = time - basicTime;
            if (payTime <= 0) return basicFee;

            return (int) (Math.ceil((double)payTime / (double)unitTime) * unitFee) + basicFee;
        }
    }
}