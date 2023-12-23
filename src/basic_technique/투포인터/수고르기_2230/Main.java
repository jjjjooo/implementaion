package basic_technique.투포인터.수고르기_2230;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int ans = 2000000001;
        int rp = 0;
        for (int lp = 0; lp < N; lp++){
            while(arr[rp] - arr[lp] < M && rp < N - 1){
                rp++;
            }
            if (arr[rp] - arr[lp] >= M){
                ans = Math.min(ans, arr[rp] - arr[lp]);
            }
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
