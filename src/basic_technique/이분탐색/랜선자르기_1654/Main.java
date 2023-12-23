package basic_technique.이분탐색.랜선자르기_1654;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        int k = sc.nextInt();
        int n = sc.nextInt();

        int[] arrLan = new int[k];
        for (int i = 0; i < k; i ++){
            arrLan[i] = sc.nextInt();
        }

        //자를 길이 L (2 ^31 -1) 보다 작은 길이로 잘라서
        //총 N개의 랜선을 만들 것이다.
        //어떤 길이로 잘랐을 때, N개를 만들 수 있나?
        long L = 1, R = 2L << 31 - 1, ans = -1;
        while (L <= R){
            long mid = (L+R) / 2;
            if(isOK(arrLan, mid) >= n){
                ans = mid;
                L = mid + 1;
            }
            else {
                R = mid - 1;
            }
        }
        System.out.println(ans);
    }

    private static int isOK(int[] arrLan, long L) {
        int sum = 0;
        for(int i = 0; i < arrLan.length; i++){
            sum += (int) (arrLan[i] / L);
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
