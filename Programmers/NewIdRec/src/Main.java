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

// 정규표현식 이용
//class Solution {
//    public String solution(String new_id) {
//        String answer = "";
//        String temp = new_id.toLowerCase();
//
//        temp = temp.replaceAll("[^-_.a-z0-9]","");
//        System.out.println(temp);
//        temp = temp.replaceAll("[.]{2,}",".");
//        temp = temp.replaceAll("^[.]|[.]$","");
//        System.out.println(temp.length());
//        if(temp.equals(""))
//            temp+="a";
//        if(temp.length() >=16){
//            temp = temp.substring(0,15);
//            temp=temp.replaceAll("^[.]|[.]$","");
//        }
//        if(temp.length()<=2)
//            while(temp.length()<3)
//                temp+=temp.charAt(temp.length()-1);
//
//        answer=temp;
//        return answer;
//    }
//}