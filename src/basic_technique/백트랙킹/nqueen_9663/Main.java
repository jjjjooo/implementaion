package basic_technique.백트랙킹.nqueen_9663;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, number = 0;
    static int[] col;

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        col = new int[N + 1];
    }

    static boolean acttackable(int r1, int c1, int r2, int c2) {
        if (c1 == c2) return true;
        if (r1 - c1 == r2 - c2) return true;
        if (r1 + c1 == r2 + c2) return true;
        return false;
    }

    static void rec_func(int k) {
        if (k == N + 1) {
            number++;
        } else {
            for (int cand = 1; cand <= N; cand++) {
                boolean possible = true;
                for (int i = 1; i < k; i++) {
                    if (acttackable(k, cand, i, col[i])) {
                        possible = false;
                        break;
                    }
                }
                if (possible) {
                    col[k] = cand;
                    rec_func(k + 1);
                    col[k] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        rec_func(1);
        System.out.printf(String.valueOf(number));
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

