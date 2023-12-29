package basic_technique.정렬.좌표정렬하_11650;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] cod = new int[n][2];
        for(int i = 0; i < n; i++){
            cod[i][0] = sc.nextInt();
            cod[i][1] = sc.nextInt();
        }

        Arrays.sort(cod, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });

        for(int i = 0; i < n; i++){
            System.out.println(cod[i][0] + " " + cod[i][1]);
        }
    }
}
