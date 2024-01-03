package basic_technique.브루트포스_재귀.암호만들기_1759;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int L, C;
    static char[] str;
    static char[] ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        L = sc.nextInt();
        C = sc.nextInt();

        str = new char[C];
        ans = new char[L];
        for (int i = 0; i < C; i++)
            str[i] = sc.next().charAt(0);

        Arrays.sort(str);
        recFunc(0, 0, 0);
    }

    static void recFunc(int length, int idx, int mCnt){
        if (length == L){
            if(mCnt >= 1 && L - mCnt >= 2){
                System.out.println(ans);
            }
            return;
        }
        if(idx < C) {
            ans[length] = str[idx];
            int m = isMoum(str[idx]) ? 1 : 0;
            recFunc(length + 1, idx + 1, mCnt + m);
            ans[length] = 0;
            recFunc(length, idx + 1, mCnt);
        }
    }

    static boolean isMoum(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
