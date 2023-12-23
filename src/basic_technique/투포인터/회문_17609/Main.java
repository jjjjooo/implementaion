package basic_technique.투포인터.회문_17609;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while (n-- > 0) {
            char[] t = sc.next().toCharArray();

            int L = 0,  R = t.length - 1, ans = 0;
            while(L <= R){
                if(t[L] != t[R]){
                    if(isPsuedo(t, L+1, R) || isPsuedo(t, L, R-1)) ans =1;
                    else ans = 2;
                    break;
                }
                L++;
                R--;
            }
            System.out.println(ans);;
        }

    }
    private static boolean isPsuedo(char[] str, int L, int R) {
        while(L <= R){
            if(str[L] != str[R]) return false;
            L++;
            R--;
        }
        return true;
    }
}
