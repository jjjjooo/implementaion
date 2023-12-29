package basic_data_structure.스택.좋은단어_3986;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int ans = 0;
        while(N-- > 0){
            char[] str = sc.next().toCharArray();

            int topIdx = -1;
            char[] stack = new char[str.length];
            for(int i = 0; i < str.length; i++){
                if(topIdx >= 0 && stack[topIdx] == str[i]){
                    topIdx--;
                }
                else stack[++topIdx] = str[i];
            }

            if(topIdx < 0) ans++;
        }
        System.out.println(ans);
    }
}
