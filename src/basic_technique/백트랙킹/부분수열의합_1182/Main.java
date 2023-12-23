
package basic_technique.백트랙킹.부분수열의합_1182;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int N, SUM, answer = 0;
    static int[] numbers;

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        SUM = scan.nextInt();
        numbers = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            numbers[i] = scan.nextInt();
        }
    }


    static void rec_func(int k, int value) {
        if (k == N + 1) {
            if (value == SUM) answer++;
        } else {
            rec_func(k + 1, value + numbers[k]);
            rec_func(k + 1, value);
        }
    }

    public static void main(String[] args) {
        input();
        rec_func(1, 0);
        if (SUM == 0) {
            answer--;
        }
        System.out.printf(String.valueOf(answer));
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

