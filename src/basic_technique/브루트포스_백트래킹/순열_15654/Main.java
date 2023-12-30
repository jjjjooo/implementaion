package basic_technique.브루트포스_백트래킹.순열_15654;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int n;
    static int m;

    static int[] nums;
    static boolean[] check;
    static int[] ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        nums = new int[n];
        check = new boolean[n];
        ans = new int[m];

        for(int i = 0; i<n; i++){
            nums[i] = sc.nextInt();
        }

        Arrays.sort(nums);
        rec_fuc(0);
    }

    public static void rec_fuc(int depth){
        if(depth == m){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i<m ; i++)
                sb.append(ans[i] + " ");
            System.out.println(sb);
            return;
        }
        for(int i = 0; i < n; i++){
            if(!check[i]){
                check[i] = true;
                ans[depth] = nums[i];
                rec_fuc(depth+1);
                check[i] = false;
            }
        }
    }
}
