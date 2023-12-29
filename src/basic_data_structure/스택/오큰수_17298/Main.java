package basic_data_structure.스택.오큰수_17298;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ans = new int[N];
        int[] arr = new int[N];
        int[] stack = new int[N];
        int top = -1;
        for(int i = 0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N-1; i >= 0; i--){
            while(top >= 0 && stack[top] <= arr[i])
                top--;
            ans[i] = top < 0 ? -1 : stack[top];
            stack[++top] = arr[i];
        }

        for(int i = 0; i < N; i++){
            bw.append(ans[i] + " ");
        }
        bw.flush();
    }
}
