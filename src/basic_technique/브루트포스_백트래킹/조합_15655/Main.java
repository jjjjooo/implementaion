package basic_technique.브루트포스_백트래킹.조합_15655;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int n;
    static int m;
    static int[] nums;
    static int[] ans;
    static boolean[] check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        check = new boolean[n];
        nums = new int[n];
        ans = new int[m];
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        Arrays.sort(nums);
        recursion_func(0, 0);
    }

    public static void recursion_func(int depth, int iter) {
        if (depth == m) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sb.append(ans[i] + " ");
            }
            System.out.println(sb);
            return;
        }
        for (int i = iter; i < n; i++) {
            if (!check[i]) {
                check[i] = true;
                ans[depth] = nums[i];
                recursion_func(depth + 1, i+1);
                check[i] = false;
            }
        }
    }
}
