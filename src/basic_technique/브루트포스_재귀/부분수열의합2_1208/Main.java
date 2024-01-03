package basic_technique.브루트포스_재귀.부분수열의합2_1208;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static int s;
    static int[] nums;
    static long ans = 0;

    static int status = -1;
    static final int  LEFT = 0;
    static final int  RIGHT = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        s = sc.nextInt();
        nums = new int[n];
        for(int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        status = LEFT;
        recFun(0, n/2, 0);

        status = RIGHT;
        recFun(n/2 , n , 0);

        if(s == 0) ans--;
        System.out.println(ans);
    }

    static Map<Integer, Integer> cnt = new HashMap<>();
    public static void recFun(int idx, int end, int sum){
        if(idx == end){
            if(status == LEFT){
                cnt.put(sum, cnt.getOrDefault(sum,0) +1);
            }
            else if (status == RIGHT){
                ans += cnt.getOrDefault(s-sum, 0);
            }
            return;
        }
        recFun(idx + 1 , end, sum);
        recFun(idx + 1, end, sum + nums[idx]);
    }
}
