package basic_technique.이분탐색.나무자르기2_2805;

import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(func());
    }

    static int N;
    static int M;
    static int[] trees;


    private static long func() {
        // 나무의 최소 값고 나무의 최대값의 중간값으로 결정자 찾기
        long left = 0;
        long right = 2000000000;
        long result = 0;

        while (left <= right) {
            long mid = (left + right) / 2;
            if(cutting(trees, mid)){
                left = mid + 1;
                result = mid;
            } else {
                right = mid - 1 ;
            }
        }
        return result;
    }

    private static boolean cutting(int[] trees, long mid) {
        long sum = 0;
        for (int i = 1; i <= N; i++) {
            if(trees[i] - mid > 0){
                sum += trees[i] - mid;
            }
        }
        if(sum >= M) return true;
        return false;
    }


    private static void input() throws IOException {
        N = scan.nextInt();
        M = scan.nextInt();
        trees = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            trees[i] = scan.nextInt();
        }
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
