package basic_technique.정렬.두수의합_3273;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        func();
    }

    static int N, SUM, ans;
    static int[] A;

    private static void func() {
        Arrays.sort(A, 1, N+1);

        for (int i=1; i<=N; i++){
            binary(A, i + 1 , N, A[i]);
        }

        System.out.println(ans);
    }

    private static void binary(int[] a, int L, int R, int X) {
        while(L <= R){
            int mid = (L+R)/2;
            if(X + a[mid] == SUM){
                ans++;
                return;
            }
            else if(X + a[mid] > SUM){
                R = mid - 1;
            } else if (X + a[mid] < SUM) {
                L = mid + 1;
            }
        }
    }

    private static void input() throws IOException {
        N = scan.nextInt();
        A = new int[N+1];
        for (int i=1; i<=N; i++){
            A[i] = scan.nextInt();
        }
        SUM = scan.nextInt();
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
