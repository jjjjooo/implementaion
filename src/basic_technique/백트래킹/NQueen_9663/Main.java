package basic_technique.백트래킹.NQueen_9663;

import java.util.Scanner;

public class Main {

    static int N;
    static int[] chessCol;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        chessCol = new int[N];
        System.out.println(func(0));
    }

    private static int func(int row) {
        int cnt = 0;
        if(row == N) return 1;

        for(int col =  0; col < N; col++){
            if(isAttack(row, col)){
                chessCol[row] = col;
                cnt += func(row + 1);
            }
        }
        return cnt;
    }
    private static boolean isAttack(int row, int col){
        for(int i = 0; i < row; i++){
            if(chessCol[i] == col) return false;
            if(Math.abs(row - i) == Math.abs(col - chessCol[i])) return  false;
        }
        return true;
    }
}
