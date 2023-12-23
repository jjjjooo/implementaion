package basic_technique.정렬.접두사찾기_14426;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static FastReader sc = new FastReader();
    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();
        String[] ns = new String[n];
        String[] ms = new String[m];
        for(int i = 0; i<n; i++){
            ns[i] = sc.next();
        }
        for(int i = 0; i<m; i++){
            ms[i] = sc.next();
        }
        Arrays.sort(ns);

        int result = 0, cnt = 0;
        for(int i = 0; i<m; i++){
            int L = 0, R = ns.length-1;
            while(L <= R){
                int mid = (L + R) / 2;
                if(ns[mid].compareTo(ms[i]) < 0) L = mid + 1;
                else {
                    result = mid;
                    R = mid - 1;
                }
            }
            if(ns[result].startsWith(ms[i])) cnt++;
        }
        System.out.println(cnt);
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
