import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int croLen = getCroLen(sc.nextLine());

        System.out.println(croLen);
        sc.close();
    }

    public static int getCroLen(String str){
        String s = str.replaceAll("c=","*").replaceAll("c-","*").replaceAll("dz=","*").replaceAll("d-","*").replaceAll("lj","*").replaceAll("nj","*").replaceAll("s=","*").replaceAll("z=","*");

        return s.length();
    }
}
