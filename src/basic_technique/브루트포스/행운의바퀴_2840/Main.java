package basic_technique.브루트포스.행운의바퀴_2840;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();

    public static void main(String[] args) throws IOException {
        input();
        func();
    }

    static int N, K;
    static Order[] orders;
    static char[] ans;

    private static void func() {
        int arrow = 0;
        ans[0] = orders[0].at;
        for (int i = 1; i < K; i++) {
            int loc = orders[i].changed + arrow;

            if (loc > N - 1) loc %= N;
            if(ans[loc] != '?' && orders[i].at != ans[loc] && loc !=0) {
                System.out.println("!");
                return;
            }
            ans[loc] = orders[i].at;
            arrow = loc;
        }

        for (int i = 0; i < ans.length - 1; i++) {
            for (int j = i + 1; j < ans.length; j++) {
                if ((ans[i] == ans[j]) && (ans[i] != '?' && ans[j] != '?')) {
                    System.out.println("!");
                    return;
                }
            }
        }

        for (int i = N; i>0; i--){
            int out = arrow + i;
            if(out > N-1) out -= N;
            System.out.print(ans[out]);
        }
    }

    private static class Order {
        int changed;
        char at;

        public Order(int changed, char at) {
            this.changed = changed;
            this.at = at;
        }
    }

    private static void input() throws IOException {
        N = scan.nextInt();
        K = scan.nextInt();
        orders = new Order[K];
        ans = new char[N];
        Arrays.fill(ans, '?');
        for (int i = 0; i < K; i++) {
            int changed = scan.nextInt();
            char at = scan.next().charAt(0);
            orders[i] = new Order(changed, at);
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader(String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
