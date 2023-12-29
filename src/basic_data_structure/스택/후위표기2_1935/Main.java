package basic_data_structure.스택.후위표기2_1935;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        char[] op = sc.next().toCharArray();
        double[] nums = new double[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextDouble();
        }
        double[] stack = new double[op.length];

        int top = -1;
        for (int i = 0; i < op.length; i++) {
            if ('A' <= op[i] && op[i] <= 'Z') {
                stack[++top] = nums[op[i] - 'A'];
            } else {
                if(top >= 1){
                    double o1 = stack[top--];
                    double o2 = stack[top];
                    if (op[i] == '*') {
                        stack[top] = o2 * o1;
                    } else if (op[i] == '/') {
                        stack[top] = o2 / o1;
                    } else if (op[i] == '+') {
                        stack[top] = o2 + o1;
                    } else if ( op[i] == '-') {
                        stack[top] = o2 - o1;
                    }
                }
            }
        }
        System.out.printf("%.2f", stack[top]);
    }
}
