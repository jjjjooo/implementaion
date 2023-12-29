package basic_data_structure.스택.괄호_9012;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while(T-- > 0){
            char[] str = sc.next().toCharArray();
            int[] stack = new int[str.length];
            int top = -1;
            String ans = "YES";
            for(char c : str){
                if(c == '(')
                    stack[++top] = c;

                else if (c == ')'){
                    if(top < 0 ||stack[top] != '('){
                        ans = "NO";
                        break;
                    }
                    top--;
                }
            }
            if(top>=0) ans = "NO";
            System.out.println(ans);
        }
    }
}
