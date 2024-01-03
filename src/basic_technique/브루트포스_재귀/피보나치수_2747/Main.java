package basic_technique.브루트포스_재귀.피보나치수_2747;

import java.util.Scanner;

public class Main {

    static  int N;
    static int[] fibo = new int[50];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        System.out.println(rec_fuc(N));
    }

    static int rec_fuc(int i){
        if(i == 1 || i == 2) return 1;
        if(fibo[i] != 0) return  fibo[i];
        fibo[i] = rec_fuc(i-1) + rec_fuc(i-2);
        return fibo[i];
    }
}
