package basic_technique.이분탐색.세수의합_2295;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] preSum = new int[n * (n + 1) / 2];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                preSum[index++] = arr[i] + arr[j];
            }
        }

        Arrays.sort(arr);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < preSum.length-1; j++) {
                int target = preSum[j] + arr[i];

                int L = 0, R = n - 1;
                while (L <= R) {
                    int mid = (L + R) / 2;
                    if(target > arr[mid]) L = mid + 1;
                    else if (target < arr[mid]) R = mid - 1;
                    else if (target == arr[mid]){
                        ans = Math.max(ans, arr[mid]);
                        break;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}