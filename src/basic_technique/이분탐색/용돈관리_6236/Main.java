package basic_technique.이분탐색.용돈관리_6236;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();

        int L = 0, R = 0, mid = 0;
        int[] moneyList = new int[n];
        for (int i = 0; i < n; i++){
            moneyList[i] = sc.nextInt();
            L = Math.max(L, moneyList[i]);
            R += moneyList[i];
        }


        while(L <= R){
            mid = (L + R) / 2;
            if(isOk(moneyList,mid) > m) {
                L = mid + 1;
            }
            else  R = mid -1;

        }
        System.out.println(mid);
    }

    private static int isOk(int[] moneyList, int inchul) {
        int cnt = 0;
        int pocket = 0;
        for (int i  = 0; i < moneyList.length; i++){
            if(moneyList[i] > inchul) return 10001;
            if(moneyList[i] > pocket){
                pocket = inchul;
                cnt++;
            }
            pocket = pocket - moneyList[i];
        }
        return cnt;
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
