package basic_data_structure.스택.크게만들기_2812;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        char[] str = sc.next().toCharArray();

        int top = -1;
        char[] stack = new char[n-k];
        int kCnt = 0;
        for (int i = 0; i < n; i++){
            while(top >=0 && kCnt < k && str[i] > stack[top]){
                top--;
                kCnt++;
            }
            if(top >= n-k-1) continue;
            stack[++top] = str[i];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = top; i >=0; i--){
            sb.append(stack[i]);
        }
        System.out.println(sb.reverse());
    }
}
