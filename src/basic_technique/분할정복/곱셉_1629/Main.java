package basic_technique.분할정복.곱셉_1629;

import java.util.Scanner;

public class Main {

    static int c,a,b;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        System.out.println(func(a,b));

    }

    public static long func(long a, long b){
        if(b==1) return a % c;
        long mid = func(a, b/2);
        if(b % 2 == 0){
            return (mid * mid) % c;
        }
        else {
            return (((mid*mid)%c)*a) % c;
        }
    }
}
