import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MainForm {
    static FastReader sc = new FastReader();

    public static void main(String[] args) throws IOException {
        int n = sc.nextInt();
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
            if(arr[i]> max) max = arr[i];
        }

        double jojak = (double) max*0.01;

        double jojakSum = 0;
        for(int i = 0; i<n; i++){
            jojakSum += (double) arr[i] /jojak;
        }
        System.out.println(jojakSum /(double)n);
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