package basic_technique.브루트포스_백트래킹.연산자끼워넣기_14888;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static void input(){
        FastReader scan = new FastReader();
        N = scan.nextInt();
        op = new int[5];
        order = new int[N];
        number = new int[N+1];
        for(int i = 1; i<=N; i++){
            number[i] = scan.nextInt();
        }
        for(int i = 1; i<=4; i++){
            op[i] = scan.nextInt();
        }
    }
    static int N, SUM = 0;
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;
    static int[] number, op, order;

    static int calculator(){
        int value = number[1];
        for(int i = 1; i<=N-1; i++){
            if(order[i] == 1) value += number[i+1];
            if(order[i] == 2) value -= number[i+1];
            if(order[i] == 3) value *= number[i+1];
            if(order[i] == 4) value /= number[i+1];
        }
        return value;
    }

    static void rec_func(int k) {
        if (k == N) {
            int value = calculator();
            MAX = Math.max(MAX, value);
            MIN = Math.min(MIN, value);
        } else {
            for(int cand = 1; cand <=4 ; cand++){
                if(op[cand] >= 1){
                    op[cand]--;
                    order[k] = cand;
                    rec_func(k+1);
                    op[cand]++;
                    order[k] = 0;
                }

            }
        }
    }

    public static void main(String[] args) {
        input();
        rec_func(1);
        sb.append(MAX);
        sb.append('\n');
        sb.append(MIN);
        System.out.printf(sb.toString());
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

