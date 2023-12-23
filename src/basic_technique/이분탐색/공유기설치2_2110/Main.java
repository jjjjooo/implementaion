package basic_technique.이분탐색.공유기설치2_2110;

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

    static int N,C;
    static int[] A;

    private static void func() {
        Arrays.sort(A, 1, N+1);
        int L = 1, R = 1000000000, ans = 0;
        while (L<=R){
            int mid = (L+R)/2;
            if(determine(mid)){
                ans = mid;
                L = mid + 1;
            } else {
                R = mid -1;
            }
        }
        System.out.println(ans);
    }

    private static  boolean determine(int D){
        int cnt = 1, last = A[1];
        for (int i =2; i<= N; i++){
            if (A[i] - last >= D){
                cnt++;
                last = A[i];
            }
        }
        return cnt >= C;
    }

    private static void input() throws IOException {   N = scan.nextInt();
        C = scan.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = scan.nextInt();
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
