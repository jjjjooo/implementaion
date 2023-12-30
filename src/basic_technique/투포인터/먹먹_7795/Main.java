package basic_technique.투포인터.먹먹_7795;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i++){
                a[i] = sc.nextInt();
            }
            int[] b = new int[m];
            for(int i = 0; i < m; i++){
                b[i] = sc.nextInt();
            }
            Arrays.sort(b);
            Arrays.sort(a);

            int ans = 0;
            int rp = 0;
            for(int lp = 0; lp < n; lp++) {
                while(rp < m && b[rp] < a[lp]) rp++;
                ans += rp;
            }
            System.out.println(ans);
        }
    }
}
