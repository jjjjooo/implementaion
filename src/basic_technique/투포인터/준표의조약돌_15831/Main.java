package basic_technique.투포인터.준표의조약돌_15831;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {

    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        int n = sc.nextInt();
        int b = sc.nextInt();
        int w = sc.nextInt();
        char[] load = sc.next().toCharArray();

        int L = 0, R = 0;
        int bc = 0, wc = 0;
        int ans = 0;
        while(L < n){
            while(R < n){
                if(bc == b && load[R] == 'B') break;
                if(load[R++] == 'W') wc++;
                else bc++;
            }
            if(wc >= w)
                ans = Math.max(ans, R-L);
            if(load[L] == 'W') wc--;
            else bc--;
            L++;
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
