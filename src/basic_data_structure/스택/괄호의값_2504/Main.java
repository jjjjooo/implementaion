package basic_data_structure.스택.괄호의값_2504;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] str = sc.next().toCharArray();
        Elem[] stack = new Elem[30];
        int top = -1;
        boolean isValid = true;
        for(char c : str){
            if(c == '(' || c == '['){
                stack[++top] = new Elem(true, getmultiValue(c));
            }
            else if (c == ')' || c == ']'){
                int innerSum = 0;
                while(top >= 0 && !stack[top].type){
                    innerSum += stack[top--].value;
                }
                if(top < 0 || stack[top].value != getmultiValue(c)) {
                    System.out.println(0);
                    return;
                }
                int score = innerSum * getmultiValue(c);
                if(score == 0) score = getmultiValue(c);
                stack[top] = new Elem(false, score);
            }
        }
        int ans = 0;
        while(top >= 0){
            if(stack[top].type){
                ans = 0;
                break;
            }
            ans+= stack[top--].value;
        }

        System.out.println(ans);
    }

    private static int getmultiValue(char c) {
        if(c == '(' || c == ')'){
            return 2;
        }
        else if(c == '[' || c == ']'){
            return 3;
        }
        return 0;
    }

    static class Elem{
        Boolean type;
        int value;

        public Elem(Boolean type, int value) {
            this.type = type;
            this.value = value;
        }
    }
}

