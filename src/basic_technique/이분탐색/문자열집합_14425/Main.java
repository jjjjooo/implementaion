package basic_technique.이분탐색.문자열집합_14425;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        String[] set = new String[n];
        for (int i = 0; i < n; i++) {
            set[i] = sc.next();
        }

        Arrays.sort(set);
        int cnt = 0;
        while (m-- > 0) {
            String input = sc.next();

            int L = 0, R = n - 1;
            while (L <= R) {
                int mid = (L + R) / 2;
                if (set[mid].compareTo(input) > 0) R = mid - 1;
                else if (set[mid].compareTo(input) < 0) L = mid +1;
                else if (set[mid].equals(input)){
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }
}
