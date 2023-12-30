package basic_technique.브루트포스_백트래킹.부분수열의합_1182;

import java.util.Scanner;

public class Main {

    static int n, m, cnt;
    static int T;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        T = sc.nextInt();


        while (T-- > 0) {
            cnt = 0;
            n = sc.nextInt();
            m = sc.nextInt();
            recFunc(0, 1);
            System.out.println(cnt);
        }
    }

    static void recFunc(int depth, int start) {
        if (start > m * 2) return;
        if (depth == n) {
            cnt++;
            return;
        }
        for (int i = start; i <= m; i++) {
            recFunc(depth + 1, i * 2);
        }
    }
}
