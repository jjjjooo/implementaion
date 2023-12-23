package basic_technique.구간합.생명겡임_17232;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int t = sc.nextInt();
        int k = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        char[][] map = new char[n+1][n+1];
        for (int i = 1; i <= n; i++){
            String row = sc.next();
            for (int j = 1; j <=m; j++){
                map[i][j] = row.charAt(j - 1);
            }
        }

        while(t-- > 0){
            int [][] acc = getPreSum(map);
            for (int i = 1; i <= n; i++){
                for (int j = 1; j <=m; j++) {
                    int alive = getSum(acc, i, j, k);
                    if (map[i][j] == '*') {
                        alive--;
                        if (alive < a || b < alive)
                            map[i][j] = '.';
                    }
                    else if (a < alive && alive <= b)
                        map[i][j]  = '*';
                }
            }
        }
        for (int i = 1; i <=n; i++){
            for(int j = 1; j <=m; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    private static int getSum(int[][] acc, int r, int c, int k) {
        int r1 = Math.max(r - k, 1);
        int c1 = Math.max(c - k, 1);
        int r2 = Math.min(r + k, acc.length-1);
        int c2 = Math.min(c + k, acc[0].length -1);
        return acc[r2][c2] - acc[r2][c1-1] - acc[r1-1][c2] + acc[r1-1][c1-1];
    }

    private static int[][] getPreSum(char[][] map) {
        int[][] acc = new int[map.length][map[0].length];
        for(int i = 1; i < map.length; i++){
            for (int j = 1; j < map[0].length; j++){
                acc[i][j] = acc[i-1][j] + acc[i][j-1] - acc[i-1][j-1] + (map[i][j] == '*' ? 1 : 0);
            }
        }
        return acc;
    }
}
