package basic_technique.이분탐색.수찾기_1920;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static FastReader sc = new FastReader();
    public static void main(String[] args) {
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) arr[i] = sc.nextInt();

        int M = sc.nextInt();
        int[] finder = new int[M];
        for(int i = 0; i < M; i++) finder[i] = sc.nextInt();

        Arrays.sort(arr);

        for(int i = 0; i < M; i++){
            int X = finder[i];
            int L = 0, R = N-1;
            int ans = 0;
            while(L <= R){
                int mid = (L + R) / 2;
                if (arr[mid] > X) R = mid - 1;
                else if (arr[mid] < X) L = mid + 1;
                else {
                    ans = 1;
                    break;
                }
            }
            System.out.println(ans);
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
    }
}
