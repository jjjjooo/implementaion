package basic_grahp.디피.설탕배달_2839;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static FastReader sc = new FastReader();
    public static void main(String[] args) throws IOException {
        /**
         * DP 사용하지 않음
         */
        int N = sc.nextInt();
        int n = N;
        int cnt = 0;
        if(n % 5 == 0) {
            cnt = n / 5;
        } else {
            while (n >= 3) {
                n -= 3;
                cnt++;
                if (n % 5 == 0) {
                    cnt += (n / 5);
                    break;
                }
            }
        }
        if(0<n && n<3) System.out.println(-1);
        else System.out.println(cnt);
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