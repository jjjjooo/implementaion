package basic_technique.이분탐색.두용액_2470;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader sc = new FastReader();
    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        int v1 = 0;
        int v2 = 0;
        for (int i = 0; i < n-1; i++) {
            int pair = findAnother(arr, i + 1, n - 1, arr[i]);
            int abs = Math.abs(arr[i] + pair);
            if(abs < min){
                min = abs;
                v1 = arr[i];
                v2 = pair;
            }
        }
        System.out.println(v1 + " " + v2);
    }

    private static int findAnother(int[] arr, int from, int to, int value) {
        int pair = 0;
        int pairAbs = Integer.MAX_VALUE;
        int l = from, r = to;
        while(l <= r){
            int mid = (l + r) /2;
            int sum = value + arr[mid];
            int sumAbs = Math.abs(sum);
            if(sumAbs < pairAbs){
                pair = arr[mid];
                pairAbs = sumAbs;
            }
            if(sum < 0) l = mid +1;
            else if (sum > 0) r = mid -1;
            else return arr[mid];
        }
        return pair;
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
