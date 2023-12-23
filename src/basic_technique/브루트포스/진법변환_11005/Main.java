package basic_technique.브루트포스.진법변환_11005;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        for(int i = 0; i<R.length; i++) R[i] = -1;
        input();
        trans();
        func();
    }

    static int N, B;
    static int[] R = new int[30];

    private static void func() {
        for(int i = R.length-1; i>=0; i--){
            if(R[i] !=-1){
                if(R[i] > 9) sb.append((char)(R[i]+55));
                else sb.append((R[i]));

            }
        }
        System.out.println(sb);
    }
    private static void trans(){
        int i = 0;
        while (N > 0) {
            int r = N % B;
            R[i++] = r;
            N = N / B;
        }
    }

    private static void input() throws IOException {
        N = scan.nextInt();
        B = scan.nextInt();
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
