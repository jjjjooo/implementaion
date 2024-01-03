package basic_technique.분할정복.색종이만들기_2630;

import java.util.Scanner;

public class Main {

    static int N;
    static int[][] paper;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        paper = new int[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                paper[i][j] = sc.nextInt();
            }
        }

        func(0,0,N);
        System.out.println(whiteCnt);
        System.out.println(blueCnt);
    }
    static int whiteCnt = 0, blueCnt = 0;
    private static void func(int r, int c, int len) {
        if(isSame(r,c,len)){
            if(paper[r][c] == 1) blueCnt++;
            else whiteCnt++;
            return;
        }
//        else {
//            for(int i = 0; i < len; i++){
//                for(int j = 0; j < len; i++){
//                    if(paper[r+i][c+j] == 1) blueCnt++;
//                }
//            }
//
//        }
        int mid = len / 2;
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                func(r +(mid*i), c + (mid*j), mid);
            }
        }
    }

    private static boolean isSame(int startR, int startC, int len) {
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                if(paper[startR][startC] != paper[startR+i][startC+j]) return false;
            }
        }
        return true;
    }
}
