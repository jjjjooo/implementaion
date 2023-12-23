package basic_technique.정렬.약속_1183;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static FastReader sc = new FastReader();
    public static void main(String[] args) {

        int n = sc.nextInt();
        int[] time = new int[n];
        for(int i = 0; i< n; i++) {
            int p = sc.nextInt();
            int a = sc.nextInt();
            time[i] = p - a;
        }

        Arrays.sort(time);

        if(n % 2 == 1) System.out.println(1);
        else System.out.println(Math.abs(time[n/2] - time[n/2-1])+1);
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
