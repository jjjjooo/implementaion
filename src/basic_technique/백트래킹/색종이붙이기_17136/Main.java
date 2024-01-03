package basic_technique.백트래킹.색종이붙이기_17136;

import java.util.Scanner;

public class Main {

    static int[] color = {5,5,5,5,5};
    static int[][] paper = new int[10][10];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++)
                paper[i][j] = sc.nextInt();
        }

        func(0,0,0);
        System.out.println(answer == 30 ? -1 : answer);
    }

    static int answer = 30;
    public static void func(int row, int col, int cnt) {
        if(answer <= cnt) return;
        int[] next = findNext(row, col);
        if(next[0] == -1 && next[1] == -1){
            answer = cnt;
            return;
        }
        int r = next[0];
        int c = next[1];

        for(int size = 0; size < 5; size++){
            if(color[size] == 0) continue;
            if(!isAttach(r,c, size+1)) continue;
            color[size]--;
            fill(r, c, size + 1, 0);
            func(r, c, cnt + 1);
            fill(r, c, size + 1, 1);
            color[size]++;
        }
    }

    public static void fill(int row, int col, int size, int i) {
        for(int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                paper[row + r][col + c] = i;
            }
        }
    }

    public static boolean isAttach(int row, int col, int size) {
        if(row + size > 10 || col + size > 10) return false;
        for(int r = 0; r < size; r++){
            for(int c = 0; c < size; c++){
                if(paper[row + r][col + c] == 0)
                    return false;
            }
        }
        return true;
    }

    public static int[] findNext(int r, int c) {
        for(int i = r; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(paper[i][j] == 1){
                    return (new int[] {i, j});
                }
            }
        }
        return new int[] {-1, -1};
    }
}
