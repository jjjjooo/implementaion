package basic_technique.기본재귀.중복순열_15656;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int m;

    static int n;

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
        recFunc(0);
        System.out.println(sb);
    }

    private static void recFunc(int depth) {
        if(depth == m){
            for(int i = 0; i<m; i++)
                sb.append(ans[i] + " ");
            sb.append("\n");
            return;
        }
        for (int i = 0; i < n; i++){
            ans[depth] = nums[i];
            recFunc(depth + 1);
        }
    }
}
