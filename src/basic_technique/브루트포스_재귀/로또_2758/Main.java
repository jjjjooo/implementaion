package basic_technique.브루트포스_재귀.로또_2758;

import java.util.Scanner;

public class Main {

    static long[][] mem;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            mem = new long[n + 1][m + 1];

            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= m; j++) {
                    mem[i][j] = -1;
                }
            }
            System.out.println(recFunc(n, m));
        }
    }

    static long recFunc(int depth, int last) {
        if (last <= 0) return 0;
        if (depth == 1) return last;
        if (mem[depth][last] == -1) {
            mem[depth][last] = recFunc(depth - 1, last / 2) + recFunc(depth, last - 1);
        }
        return mem[depth][last];
    }
}