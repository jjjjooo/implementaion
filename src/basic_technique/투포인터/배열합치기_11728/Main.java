package basic_technique.투포인터.배열합치기_11728;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static FastReader sc = new FastReader();

    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];
        int[] ans = new int[n + m];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }

        int p1 = 0, p2 = 0, ansIdx = 0;

        while(p1 < n && p2 < m){
            if(arr1[p1] < arr2[p2])
                ans[ansIdx++] = arr1[p1++];
            else ans[ansIdx++] = arr2[p2++];
        }
        while(p1 < n) ans[ansIdx++] = arr1[p1++];
        while(p2 < m) ans[ansIdx++] = arr2[p2++];
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n + m; i++) {
            bw.write(ans[i] + " ");
        }
        bw.flush();
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
