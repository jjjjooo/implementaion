package basic_technique.정렬.카드_11652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        input();
        System.out.printf(String.valueOf(func()));
    }

    static int N;

    static long[] NUMS;

    private static int func() {
        int cnt = 1, max = 1, min_idx = 0;
        Arrays.sort(NUMS);
        for(int i=0; i<N-1; i++){
            if(NUMS[i] != NUMS[i+1]) {
                if(cnt > max){
                    max = cnt;
                    min_idx = (int) NUMS[i];
                }
                cnt = 1;

            }
            else cnt++;
        }
        return min_idx;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        NUMS = new long[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            NUMS[i] = Long.parseLong(st.nextToken());
        }
    }
}