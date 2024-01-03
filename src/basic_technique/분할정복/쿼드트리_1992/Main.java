package basic_technique.분할정복.쿼드트리_1992;

import java.util.Objects;
import java.util.Scanner;

public class Main {

    static int N;
    static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String next = sc.next();
            for (int j = 0; j < N; j++)
                map[i][j] = next.charAt(j) - '0';
        }
        System.out.println(func(N, 0, 0));
    }

    public static String func(int n, int startRow, int startCol) {
        if (n == 1) {
            return String.valueOf(map[startRow][startCol]);
        }
        int mid = n / 2;
        String d1 = func(mid, startRow, startCol);  // 좌상단
        String d2 = func(mid, startRow, startCol + mid); // 우상단
        String d3 = func(mid, startRow + mid, startCol); // 좌하단
        String d4 = func(mid, startRow + mid, startCol + mid); // 우하단

        return merge(d1, d2, d3, d4);
    }

    private static String merge(String d1, String d2, String d3, String d4) {
        StringBuilder sb = new StringBuilder();
        if (d1.startsWith("(") || d2.startsWith("(") || d3.startsWith("(") || d4.startsWith("("))
            return sb.append("(").append(d1).append(d2).append(d3).append(d4).append(")").toString();

        if (!Objects.equals(d1, d2) || !Objects.equals(d2, d3) || !Objects.equals(d3, d4))
            return sb.append("(").append(d1).append(d2).append(d3).append(d4).append(")").toString();

        if (d1.startsWith("0")) return sb.append(0).toString();
        if (d1.startsWith("1")) return sb.append(1).toString();
        return sb.toString();
    }

    // 최적화 코드
    public static void compress(int r, int c, int length) {
        if (isSame(r, c, length)) {
            System.out.println(map[r][c]);
            return;
        }
        System.out.print("(");
        int mid = length / 2;
        compress(r, c, mid);  // 좌상단
        compress(r, c + mid, mid); // 우상단
        compress( r + mid, c, mid); // 좌하단
        compress(r + mid, c + mid, mid); // 우하단
        System.out.print("(");
    }
    public static boolean isSame(int r, int c, int length){
        for(int i = 0; i < length; i++){
            for(int j  = 0; j < length; j++){
                if(map[r][c] != map[r+i][r+j]) return false;
            }
        }
        return true;
    }
}
