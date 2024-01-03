package basic_technique.백트래킹.좋은수열_2661;

import java.util.Scanner;

public class Main {

    static int N;
    static int[] ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        ans = new int[N];
        func(0);
    }
    static boolean func(int depth){
        if(depth == N){
            for(int i = 0; i < N ; i++) {
                System.out.print(ans[i]);
            }
            return true;
        }
        for (int i = 1; i <=3; i++){
            ans[depth] = i;
            if(!badCase(depth)){
                if(func(depth + 1)) return  true;
            }
        }
        return false;
    }

    private static boolean badCase(int depth) {
        for(int i = 1; i <= (depth + 1) / 2; i++){
            boolean isSame = true;
            for(int j = 0; j < i; j++){
                if(ans[depth - j] != ans[depth-j-i]){
                    isSame = false;
                    break;
                }
            }
            if(isSame) return true;

        }
        return false;
    }
}
