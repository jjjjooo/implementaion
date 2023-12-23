package basic_technique.투포인터.부분합_1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int ans = n + 1;
        int rp = 0;
        int sum = arr[0];
        for (int lp = 0; lp < n; lp++) {
            while (sum < s && rp < n - 1) {
                sum += arr[++rp];
            }
            if(sum >= s)
                ans = Math.min(rp-lp+1, ans);
            sum -= arr[lp];
        }
        if (ans > n) ans = 0;
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
