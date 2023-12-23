package basic_technique.투포인터.고냥이_16472;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        int n = sc.nextInt();
        char[] str = sc.next().toCharArray();
        int[] alpha = new int[26];

        int rp = 0;
        int ans = 0;

        for (int lp = 0; lp < str.length; lp++) {
            while (rp < str.length) {
                alpha[str[rp]-97]++;
                rp++;
                int count = getCount(alpha);
                if(count > n){
                    alpha[str[--rp] - 97]--;
                    break;
                }
            }
            ans = Math.max(ans, rp-lp);
            alpha[str[lp]-97]--;
        }
        System.out.println(ans);
    }

    private static int getCount(int[] alpha) {
        int cnt = 0;
        for (int i = 0; i < alpha.length; i++) {
            if (alpha[i] > 0) cnt++;
        }
        return cnt;
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
