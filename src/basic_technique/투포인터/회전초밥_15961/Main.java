package basic_technique.투포인터.회전초밥_15961;

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
        int X = sc.nextInt();

        int[] bangNum = new int[N];
        for (int i = 0; i < N; i++) {
            bangNum[i] = sc.nextInt();
        }

        int[] noBang = new int[M];
        for (int i = 0; i < M; i++) {
            noBang[i] = sc.nextInt();
        }

        Arrays.sort(bangNum);
        Arrays.sort(noBang);

        int L = 0, R = Math.min(M, N);
        int ans = 0;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (isMinX(bangNum, noBang, mid) <= X) {
                ans = mid;
                L = mid + 1;

            } else R = mid - 1;
        }
        System.out.println(ans);
    }

    private static long isMinX(int[] bangNum, int[] noBang, int mid) {
        long addX = 0;
        for (int i = 0; i < mid; i++) {
            if (bangNum[i] - noBang[noBang.length - mid + i] >= 0)
                addX += bangNum[i] - noBang[noBang.length - mid + i];
        }
        return addX;
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