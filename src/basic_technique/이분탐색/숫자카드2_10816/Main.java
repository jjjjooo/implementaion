package basic_technique.이분탐색.숫자카드2_10816;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader sc = new FastReader();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();

      int[] has = new int[n];
        for (int i = 0; i < n; i++){
           has[i] =  sc.nextInt();
        }

        Arrays.sort(has);
        int m = sc.nextInt();
        while(m -- >0){
            int x = sc.nextInt();
            int lowerBound =  lower_bound(has, x);
            int upperBound =  upper_bound(has, x);
            int cnt = upperBound - lowerBound;
            bw.write(cnt + " ");
        }
        bw.flush();
    }

    private static int upper_bound(int[] has, int x) {
        int L = 0; int R = has.length;
        while(L < R){
            int mid = (R + L) / 2;
            if(has[mid] <= x) L = mid + 1;
            else R = mid;
        }
        return L;
    }

    private static int lower_bound(int[] has, int x) {
        int L = 0; int R = has.length;
        while(L < R){
            int mid = (R + L) / 2;
            if(has[mid] < x) L = mid + 1;
            else R = mid;
        }
        return L;
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
