package basic_technique.구간합.구간합4_11659;

import java.util.Scanner;

public class Main {

    static int n,m;
    static int[] arr, prefix;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n+1];
        prefix = new int[n+1];
        for(int i = 1; i <= n; i++){
            arr[i] = sc.nextInt();
            if(i>1) prefix[i] = arr[i] + prefix[i-1];
            else prefix[i] = arr[i];
        }
        StringBuilder sb = new StringBuilder();
        while(m-- > 0){
            int i = sc.nextInt();
            int j = sc.nextInt();
            sb.append(prefix[j] - prefix[i-1]).append("\n");
        }
        System.out.println(sb);
    }
}
