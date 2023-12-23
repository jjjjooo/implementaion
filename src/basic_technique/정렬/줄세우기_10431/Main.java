package basic_technique.정렬.줄세우기_10431;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        func();
    }

    static int N, TC;
    static int[][] A;

    private static void func() {

        for (int i = 1; i <= TC; i++) {
            int ans = 0;
            for (int j = 20; j > 0; j--) {
                //마지막 수부터 앞을 훑는다
                for (int k = j-1; k > 0; k--){
                    if(A[i][j] < A[i][k]) ans++;
                }

            }
            System.out.println(i + " " + ans);
        }
    }

    private static void input() throws IOException {
        TC = scan.nextInt();
        A = new int[TC + 1][21];
        for (int i = 1; i <= TC; i++) {
            for (int j = 0; j < 21; j++) {
                A[i][j] = scan.nextInt();
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
