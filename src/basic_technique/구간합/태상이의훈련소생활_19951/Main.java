package basic_technique.구간합.태상이의훈련소생활_19951;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();

    public static void main(String[] args) {
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] ground = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ground[i] = scan.nextInt();
        }

        int[] tsum = new int[n+2];
        while(m-- >0){
            int start = scan.nextInt();
            int end = scan.nextInt();
            int k =scan.nextInt();
            tsum[start] += k;
            tsum[end+1] -= k;
        }
        int[] accTsum = new int[n+1];
        for (int i = 1; i<=n; i++){
            accTsum[i] = accTsum[i - 1] + tsum[i];
        }

        for(int i = 1; i<= n ; i++){
            System.out.print(ground[i] + accTsum[i] + " ");
        }
        System.out.println();
    }

    public static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
