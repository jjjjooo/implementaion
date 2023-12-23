package basic_technique.구간합.generic_queries_16713;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] arr = new int[n+1];
        for (int i = 1; i <=n ;i++){
            arr[i] = sc.nextInt();
        }

        int[] acc = new int[n+1];
        for(int i = 1; i<=n; i++){
            acc[i] = acc[i-1] ^ arr[i];
        }

        int ans =0;
        while (q-- > 0){
            int i = sc.nextInt();
            int j = sc.nextInt();

            ans ^= acc[j] ^ acc[i-1];
        }
        System.out.println(ans);
    }
}
