import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        input();
        func();
    }

    static int N;
    static long[] nums;
    private static void func() {
        Arrays.sort(nums);

        int cnt = 1, max = 1, maxIdx = 0;
        for(int i = 1; i < N; i++) {
            if(nums[i] == nums[i-1]) cnt++;
            else cnt = 1;

            if(cnt > max) {
                max = cnt;
                maxIdx = i;
            }
        }
        System.out.println(nums[maxIdx]);
    }


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        try {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        nums = new long[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            nums[i] = Long.parseLong(st.nextToken());
        }
    }
}