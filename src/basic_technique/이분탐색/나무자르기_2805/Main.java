package basic_technique.이분탐색.나무자르기_2805;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        int n = sc.nextInt();
        long m = sc.nextLong();

        long[] treeList = new long[n];
        for (int i = 0; i < n; i++) {
            treeList[i] = sc.nextLong();
        }
        long ans = -1;
        long L = 0;
        long R = 1000000000;
        while (L <= R) {
            long mid = (L + R) / 2;
            //lower_bound찾기
            if (getM(treeList, mid) >= m) {
                L = mid + 1;
                ans = mid;
            } else if (getM(treeList, mid) < m) R = mid - 1;
        }
        System.out.println(ans);
    }

    private static long getM(long[] treeList, long mid) {
        long sum = 0;
        for (int i = 0; i < treeList.length; i++) {
            if (treeList[i] > mid)
                sum += treeList[i] - mid;
        }
        return sum;
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
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public Integer nextInt() {
            return Integer.valueOf(next());
        }

        public Long nextLong() {
            return Long.valueOf(next());
        }
    }
}
