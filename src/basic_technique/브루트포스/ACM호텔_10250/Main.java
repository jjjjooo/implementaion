package basic_technique.브루트포스.ACM호텔_10250;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();

    public static void main(String[] args) throws IOException {
        input();
        func();
    }

    static int N, H, W, TC;
    static int[][] ACM;

    private static void func() {
        int i = 0;
        while (i < TC) {
            int div = (ACM[i][2] - 1) / ACM[i][0] + 1;
            int mod = (ACM[i][2] - 1) % ACM[i][0] + 1;
            System.out.printf("%d%02d", mod, div);
            System.out.println();
            i++;
        }
    }

    private static void input() throws IOException {
        TC = scan.nextInt();
        ACM = new int[TC][3];
        for (int i = 0; i < TC; i++) {
            for (int j = 0; j < 3; j++) {
                ACM[i][j] = scan.nextInt();
            }
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
