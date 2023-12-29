package basic_data_structure.스택.스택수열_1874;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        int[] stack = new int[N + 1];
        int top = -1;
        int numIdx = 1;
        StringBuilder sb = new StringBuilder();
        for (int input : arr) {
            while(numIdx <= input){
                stack[++top] = numIdx++;
                sb.append("+\n");
            }
            //팝
            if (top < 0 || stack[top] != input) {
                System.out.println("NO");
                return;
            }
            sb.append("-\n");
            top--;
        }
        System.out.println(sb);
    }
}
