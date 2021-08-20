import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        s.solution(record);
    }
}

class Solution {
    public ArrayList<String> solution(String[] record) {
        ArrayList<String> answer = new ArrayList<>();
        HashMap<String, Users> user = new HashMap<>();
        ArrayList<String[]> list = new ArrayList<>();

        for (String line : record) {
            String[] token = line.split(" ");
            String cmd = token[0];
            String uid = token[1];

            if (cmd.equals("Enter")) {
                if (!user.containsKey(uid)) {
                    Users u = new Users(uid, token[2]);
                    user.put(uid, u);

                    list.add(new String[]{uid, "Enter"});
                } else {
                    Users u = user.get(uid);
                    u.changeNickName(token[2]);
                    list.add(new String[]{uid, "Enter"});
                }
            } else if (cmd.equals("Change")) {
                user.get(uid).changeNickName(token[2]);
            } else if (cmd.equals("Leave")) {
                list.add(new String[]{uid, "Leave"});
            }
        }

        for (String[] l : list) {
            Users u = user.get(l[0]);
            answer.add(u.toString(l[1]));
        }

        return answer;
    }
}

class Users {
    String uid;
    String nickName;

    Users() {
    }

    Users(String uid, String nickName) {
        this.uid = uid;
        this.nickName = nickName;
    }

    public void changeNickName(String nickName) {
        this.nickName = nickName;
    }

    public String toString(String cmd) {
        if (cmd.equals("Enter")) {
            return this.nickName + "님이 들어왔습니다.";
        } else if (cmd.equals("Leave")) {
            return this.nickName + "님이 나갔습니다.";
        }
        return null;
    }

}