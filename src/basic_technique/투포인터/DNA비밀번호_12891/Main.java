package basic_technique.투포인터.DNA비밀번호_12891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static FastReader sc = new FastReader();
    static char[] DNA = "ACGT".toCharArray();

    public static void main(String[] args) {
        int S = sc.nextInt();
        int P = sc.nextInt();
        char[] arr = sc.next().toCharArray();

        Map<Character, Integer> min = new HashMap<>();
        for(int i = 0; i < 4; i++){
            int value = sc.nextInt();
            min.put(DNA[i], value);
        }
        Map<Character, Integer> now = new HashMap<>();
        for(int i = 0; i < 4; i++){
           now.put(DNA[i], 0);
        }

        for(int i = 0; i <P; i++){
            now.put(arr[i], now.get(arr[i])+1);
        }

        int lp = 0, rp = P - 1;
        int ans = 0;
        for (int i = 1; i < S-P+1; i++){
            if(isContain(now, min)){
                ans++;
            }
            now.put(arr[i-1], now.get(arr[i-1])-1);
            now.put(arr[i+P-1], now.get(arr[i+P-1])+1);

        }
        if(isContain(now, min)) ans++;
        System.out.println(ans);
    }

    private static boolean isContain(Map<Character, Integer> now, Map<Character, Integer> min) {
        for(int i = 0; i< 4; i++){
            if (now.get(DNA[i]) < min.get(DNA[i])) return false;
        }
        return true;
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
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public Integer nextInt() {
            return Integer.valueOf(next());
        }
    }
}
