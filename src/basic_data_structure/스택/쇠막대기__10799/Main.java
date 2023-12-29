package basic_data_structure.스택.쇠막대기__10799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] str = br.readLine().toCharArray();
        int N = str.length;
        char[] arr = new char[N+1];
        for(int i = 1; i <=N; i++){
            arr[i] = str[i-1];
        }

        int[] laserN = new int[N+1];
        for(int i = 1; i <= N; i++){
            laserN[i] = laserN[i-1];
            if(arr[i] == '(' && arr[i+1] == ')')
                laserN[i]++;
        }
        int ans = 0;
        int top = -1;
        int[] openStack = new int[N + 1];
        for(int i = 1; i <= N ; i++){
            if(arr[i] == '(' && arr[i + 1] != ')')
                openStack[++top] = i;
            else if (arr[i] == ')' && arr[i -1] != '(') {
                int openIdx = openStack[top--];
                ans += laserN[i] - laserN[openIdx] + 1;
            }
        }
        System.out.println(ans);
    }
}
