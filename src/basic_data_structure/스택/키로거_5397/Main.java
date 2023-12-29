package basic_data_structure.스택.키로거_5397;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while (T-- > 0) {
            char[] str = sc.next().toCharArray();
            int N = str.length;

            int leftTop = -1;
            char[] leftStack = new char[1000000];

            int rightTop = -1;
            char[] rightStack = new char[1000000];

            for (int i = 0; i < N; i++) {
                if (str[i] == '<') {
                    if (leftTop >= 0) {
                        char c = leftStack[leftTop];
                        leftStack[leftTop] = 0;
                        leftTop--;
                        rightStack[++rightTop] = c;
                    }
                } else if (str[i] == '>') {
                    if (rightTop >= 0) {
                        char c = rightStack[rightTop];
                        rightStack[rightTop] = 0;
                        rightTop--;
                        leftStack[++leftTop] = c;
                    }
                } else if (str[i] == '-') {
                    if(leftTop< 0) continue;
                    leftStack[leftTop] = 0;
                    leftTop--;
                } else {
                    leftTop++;
                    leftStack[leftTop] = str[i];

                }
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i <= leftTop; i++) sb.append(leftStack[i]+"");
            for(int i = rightTop; i >= 0; i--) sb.append(rightStack[i]+"");
            System.out.println(sb);
        }
    }
}

