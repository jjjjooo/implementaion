package basic_technique.정렬.접두사_1141;

import java.io.*;
import java.util.*;

public class Main {
    static FastReader sc = new FastReader();

    public static void main(String[] args) {
        int N = sc.nextInt();
        String[] strs = new String[N];
        for(int i = 0; i < N; i++){
            strs[i] = sc.next();
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.charAt(0) == o2.charAt(0)) return o1.length() - o2.length();
                return o1.charAt(0) - o2.charAt(0);
            }
        });
        int result = 0;
        for (int i = 0; i < N; i++){
            boolean check = false;
            for(int j = i+1; j < N; j++){
                String prefix = strs[i];
                String compare = strs[j];
                if(compare.startsWith(prefix)){
                    check = true;
                    break;
                }
            }
            if(!check){
                result++;
            }
        }
        System.out.println(result);
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
