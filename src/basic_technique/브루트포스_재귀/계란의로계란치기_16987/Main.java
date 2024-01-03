package basic_technique.브루트포스_재귀.계란의로계란치기_16987;

import java.util.Scanner;

public class Main {
    static int n;
    static Egg[] eggs;
    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        eggs = new Egg[n];
        for (int i = 0; i < n; i++)
            eggs[i] = new Egg(sc.nextInt(), sc.nextInt());
        recFunc(0);
        System.out.println(ans);
    };
    static void recFunc(int depth) {
        if (depth == n) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (eggs[i].d <= 0) cnt++;
            }
            ans = Math.max(ans, cnt);
            return;
        }
        if (eggs[depth].d > 0) {
            boolean nextExists = false;
            for (int next = 0; next < n; next++) {
                if (depth == next) continue;
                if (eggs[next].d > 0) {
                    nextExists = true;
                    eggs[depth].crash(eggs[next]);
                    recFunc(depth + 1);
                    eggs[depth].rewind(eggs[next]);
                }
            }
            if (!nextExists) recFunc(depth + 1);
        } else recFunc(depth + 1);
    }

    public static class Egg {
        int w;
        int d;

        public Egg(int d, int w) {
            this.w = w;
            this.d = d;
        }

        public void crash(Egg other) {
            this.d -= other.w;
            other.d -= this.w;
        }

        public void rewind(Egg other) {
            this.d += other.w;
            other.d += this.w;
        }
    }
}
