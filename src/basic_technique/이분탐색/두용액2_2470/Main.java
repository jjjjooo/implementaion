package basic_technique.이분탐색.두용액2_2470;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static FastReader scan = new FastReader();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        func();
    }

    static int N;
    static int[] acid;

    private static void func() {
        Arrays.sort(acid, 1, N + 1);
        int best = Integer.MAX_VALUE;
        int v1 = 0, v2 = 0;
        for (int left = 1; left <= N - 1; left++) {
            int res = lower_bound(acid, left + 1, N, -acid[left]);

            if (left + 1 <= res - 1 && res - 1 <= N && Math.abs(acid[res - 1] + acid[left]) < best) {
                best = Math.abs(acid[left] + acid[res - 1]);
                v1 = acid[left];
                v2 = acid[res-1];
            }

            if (left + 1 <= res && res <= N && Math.abs(acid[res] + acid[left]) < best) {
                best = Math.abs(acid[left] + acid[res]);
                v1 = acid[left];
                v2 = acid[res];
            }
        }
        System.out.println(sb.append(v1).append(' ').append(v2));
    }

    private static int lower_bound(int[] acid, int L, int R, int X) {
        int res = R + 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if(acid[mid] >= X){
                res = mid;
                R  = mid -1;
            } else {
                L = mid + 1;
            }
        }
        return res;
    }



    private static void input() throws IOException {
        N = scan.nextInt();
        acid = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            acid[i] = scan.nextInt();
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
