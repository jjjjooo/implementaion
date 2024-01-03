package basic_technique.브루트포스_재귀.유레카넘버_10448;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static FastReader scan = new FastReader();

    static boolean[] isEurekaNumber = new boolean[1001];

    static void preprocess() {
        int[] triangleNumbers = new int[50];
        int triangleNumberCount = 0;
        for (int i = 1; ; i++) {
            int triangleNumber = i * (i + 1) / 2;
            if (triangleNumber >= 1000) break;
            triangleNumbers[triangleNumberCount++] = triangleNumber;
        }
        boolean[] isSumOfTriangleNumber = new boolean[1001];
        for (int i = 0; i < triangleNumberCount; i++)
            for (int j = 0; j < triangleNumberCount; j++) {
                int sum = triangleNumbers[i] + triangleNumbers[j];
                if (sum < 1000) isSumOfTriangleNumber[sum] = true;
            }

        for (int i = 1; i < 1000; i++) {
            if (!isSumOfTriangleNumber[i]) continue;
            for (int j = 0; j < triangleNumberCount; j++) {
                int sum = i + triangleNumbers[j];
                if(sum <= 1000) isEurekaNumber[sum] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        preprocess();
        int T = scan.nextInt();
        while (T-- > 0) {
            int k = scan.nextInt();
            System.out.println(isEurekaNumber[k] ? "1" : "0");
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
