package basic_technique.분할정복.종이의개수_1780;

import java.util.Scanner;

public class Main {
    static int N;
    static int[][] paper;

    static int cnt0, cnt1, cntM;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        paper = new int[N][N];
        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                paper[i][j] = sc.nextInt();
            }
        }
        func(N, 0,0 );
        System.out.println(cntM);
        System.out.println(cnt0);
        System.out.println(cnt1);
    }
    static void func(int n, int row, int col){
        if(isSame(n,row,col)){
            int num = paper[row][col];
            if(num == -1) cntM++;
            else if(num == 0) cnt0++;
            else cnt1++;
            return;
        }
        n = n / 3;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                func(n, row + (i*n), col + (j*n));
            }
        }

    }

    private static boolean isSame(int n, int row, int col) {
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(paper[row][col] != paper[row + i][col + j]) return false;
            }
        }
        return true;
    }
}
