package 기타.문자열.IOIOI_5525;

import java.util.Scanner;

public class Main {

    static int N,S;
    static String M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        M = sc.next();


        int cnt = 0;
        int result = 0;
        for(int i = 1; i < S -1; i++){
            if(M.charAt(i-1) == 'I' && M.charAt(i) == 'O' && M.charAt(i+1) == 'I') {
                cnt++;

                if(cnt == N) {
                    cnt--;
                    result++;
                }
                i++;
            }
            else {
                cnt = 0;
            }
        }
        System.out.println(result);
    }
}
