public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("z-+.^."));
    }
}
class Solution {

    public String solution(String new_id) {
        String answer = "";

        for(int i=0; i<new_id.length(); i++){
            char tmp = new_id.charAt(i);
            if(('A'<=tmp)&&(tmp<='Z')){
                tmp = (char)(tmp+32);
            }
            if(('a'<=tmp&&'z'>=tmp)||('0'<=tmp&&'9'>=tmp)||tmp=='.'||tmp=='_'||tmp=='-') {
                answer += tmp;
            }
        }

        answer.replaceAll("..", ".");

        String tmp = "";
        boolean flag = false;
        for(int i=0; i<answer.length(); i++){
            if(answer.charAt(i)=='.'){
                if(!flag)
                    tmp += ".";
                flag=true;
            }
            else {
                tmp += answer.charAt(i);
                flag=false;
            }
        }
        answer=tmp;

        if(answer.charAt(0)=='.')
            answer = answer.substring(1,answer.length());
        if(answer.length() > 0 && answer.charAt(answer.length()-1)=='.')
            answer = answer.substring(0,answer.length()-1);

        if(answer.equals("")){
            answer = "aaa";
        }

        if(answer.length()<3){
            int scope = 3-answer.length();
            char last = answer.charAt(answer.length()-1);
            for(int i = scope; i>0; i--){
                answer += last;
            }
        }

        if(answer.length()>=16) {
            int idx = 15;

            if(answer.charAt(14)=='.')
                idx--;

            answer = answer.substring(0,idx);
        }

        return answer;
    }
}
