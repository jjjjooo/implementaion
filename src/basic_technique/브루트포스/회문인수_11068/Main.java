package basic_technique.브루트포스.회문인수_11068;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();

    public static void main(String[] args) throws IOException {
        input();
        int tc = 0;
        while(tc < T){
            boolean isCircle = false;
            for(int i = 2; i<= 64; i++){
                StringBuilder stringBuilder = binary_trans(i, nums[tc]);
                if(circle(stringBuilder)){
                    isCircle= true;
                    break;
                }
            }
            tc++;
            System.out.println(isCircle ? "1" : "0");
        }
    }

    static int T;
    static int[] nums;

    private static boolean circle(StringBuilder stringBuilder){
        String string = stringBuilder.toString();
        int L = 0; int R = string.length()-1;
        while(L <= R){
            if(string.charAt(L) != string.charAt(R)) return false;
            L++; R--;
        }
        return true;
    }

    private static StringBuilder binary_trans(int b, int n){
        StringBuilder rs = new StringBuilder();
        while(n>0){
            int r = n % b;
            rs.append((char)(r + 10 + 'A'));
            n = n/b;
        }
        return rs;
    }
    private static void input() throws IOException {
        T = scan.nextInt();
        nums = new int[T];
        for (int i = 0; i < T; i++) {
            nums[i] = scan.nextInt();
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
