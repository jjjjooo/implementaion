package basic_data_structure.스택.단어뒤집기2_17413;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        int point = 0;
        int cnt = s.length();
        boolean isOpened = false;

        int top = -1;
        char[] stack = new char[100000];
        StringBuilder sb = new StringBuilder();
        while(cnt-- > 0 && point < s.length()){
            if(s.charAt(point) == '<'){
                while(top >= 0){
                    sb.append(stack[top--]);
                }
                sb.append(s.charAt(point));
                isOpened  = true;
                point++;
                continue;
            }
            else if(s.charAt(point) == '>'){
                sb.append(s.charAt(point));
                isOpened = false;
                point++;
                continue;
            }
            if(isOpened) {
                sb.append(s.charAt(point));
                point++;
            }
            else {
                if(s.charAt(point) == ' '){
                    while(top>=0){
                        sb.append(stack[top--]);
                    }
                    sb.append(' ');
                    point++;
                }
                else {
                    stack[++top] = s.charAt(point);
                    point++;
                }
            }
        }
        if(top >= 0){
            for(int i = top; top>=0; top--){
                sb.append(stack[top]);
            }
        }
        System.out.println(sb);
    }
}
