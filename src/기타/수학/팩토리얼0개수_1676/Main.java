package 기타.수학.팩토리얼0개수_1676;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Tower[] arr = new Tower[N];
        int[] ans = new int[N];
        int top = -1;
        Tower[] stack = new Tower[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int h = Integer.parseInt(st.nextToken());
            arr[i] = new Tower(i+1, h);
        }

        for(int i = 0; i < N; i++){
            while(top >= 0 && stack[top].h < arr[i].h)
                top--;
            ans[i] = top < 0 ? 0 : stack[top].idx;
            stack[++top] = arr[i];
        }
        for(int i = 0; i < N; i++){
            bw.append(ans[i] + " ");
        }
        bw.flush();

    }

    static class Tower{
        int idx;
        int h;

        public Tower(int idx, int h) {
            this.idx = idx;
            this.h = h;
        }
    }
}
