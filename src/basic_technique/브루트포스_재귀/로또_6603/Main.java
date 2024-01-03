package basic_technique.브루트포스_재귀.로또_6603;

import java.util.Scanner;

public class Main {

    static int k;
    static int[] nums;

    static int[] ans;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            k = sc.nextInt();
            if (k == 0) break;
            ans = new int[6];
            nums = new int[k];
            for (int i = 0; i < k; i++)
                nums[i] = sc.nextInt();
            reFunc(0,0);
            System.out.println();
        }
    }

    static void reFunc(int depth, int startIdx) {
        if (depth == 6) {
            for(int i = 0; i<6; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
            return;
        }
        for (int i = startIdx; i < k; i++) {
            ans[depth] = nums[i];
            reFunc(depth + 1, i + 1);
        }
    }
}
