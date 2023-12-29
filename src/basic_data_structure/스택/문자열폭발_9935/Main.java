package basic_data_structure.스택.문자열폭발_9935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] str = br.readLine().toCharArray(); //원본 문자열
        char[] bomb = br.readLine().toCharArray(); // 폭탄 문자열
        int len = bomb.length;

        int top = -1; // 스택 포인터
        char[] oriStack = new char[str.length]; // 원본 문자열 to 폭탄 문자열 스택

        for (int i = 0; i < str.length; i++){
            oriStack[++top] = str[i];

            boolean isSame = true;
            if(top >= len-1){
                for(int j = 0 ; j < bomb.length; j++){
                    if(bomb[j] != oriStack[top-len+1+j]){
                        isSame = false;
                        break;
                    }
                }
                if(isSame){
                    top -= bomb.length;
                }
            }
        }
        if(top < 0) System.out.println("FRULA");
        else {
            for(int i = 0; i <=top; i++)
                sb.append(oriStack[i]);
            System.out.println(sb);
        }
    }
}
