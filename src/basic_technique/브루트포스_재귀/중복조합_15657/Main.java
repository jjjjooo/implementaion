package basic_technique.브루트포스_재귀.중복조합_15657;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int n;
    static int m;
    static int[] nums;
    static int[] ans;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();
        ans = new int[m];
        Arrays.sort(nums);
        recFunc(0 , 0);
        System.out.println(sb);
    }

    private static void recFunc(int depth, int iter) {
        if(depth == m){
            for(int i = 0; i<m; i++)
                sb.append(ans[i] + " ");
            sb.append("\n");
            return;
        }
        for (int i = iter; i < n; i++){
            ans[depth] = nums[i];
            recFunc(depth + 1, i);
        }
    }
}
