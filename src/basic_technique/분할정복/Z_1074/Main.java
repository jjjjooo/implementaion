package basic_technique.분할정복.Z_1074;

import java.util.Scanner;

public class Main {

    static int n, r, c;
    static int cnt = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        func(n, r, c);
        System.out.println(cnt);
    }

    public static void func(int n, int r, int c){
        int board = 1 << n;
        int mid = board / 2;
        if(n == 0) return;

        if(r < mid && c < mid){
            func(n-1, r, c);
        }
        else if (r < mid && c >= mid){
            cnt += mid * mid;
            func(n-1, r, c - mid);
        }

        else if (r >= mid && c < mid){
            cnt += mid * mid * 2;
            func(n-1, r - mid, c);
        }

        else if (r >= mid && c >= mid){
            cnt += mid * mid * 3;
            func(n-1, r - mid, c - mid);
        }
    }
}
