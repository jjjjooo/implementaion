package basic_technique.투포인터.두개의탑_2118;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        int n = sc.nextInt();
        int sum = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        int rp = 0, ans = -1, d = 0, rd = sum;
        for(int lp = 0; lp < n; lp++){
            while(d < rd){
                d += arr[rp];
                rd -= arr[rp];
                rp = (rp+1) % n;
            }
            ans = Math.max(ans, rd);
            d -= arr[lp];
            rd += arr[lp];
        }
        System.out.println(ans);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            this.br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public Integer nextInt() {
            return Integer.valueOf(next());
        }
    }
}
