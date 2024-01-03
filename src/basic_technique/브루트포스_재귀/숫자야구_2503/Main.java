package basic_technique.브루트포스_재귀.숫자야구_2503;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] base = new int[n][3];
        for (int i = 0; i < n; i++) {
            base[i][0] = sc.nextInt();
            base[i][1] = sc.nextInt();
            base[i][2] = sc.nextInt();
        }
        int ans = 0;
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                for (int k = 1; k < 10; k++) {
                    if(i == j || j == k || k == i) continue;
                    boolean possible = true;
                    for(int x = 0; x < n; x++){
                        int qi = base[x][0] / 100;
                        int qj = (base[x][0] / 10) % 10;
                        int qk = base[x][0] % 10;

                        int s = 0, b = 0;
                        if(qi == i) s++;
                        else if(qi == j || qi == k) b++;

                        if(qj == j) s++;
                        else if(qj == i || qj == k) b++;

                        if(qk == k) s++;
                        else if(qk == i || qk == j) b++;

                        if(base[x][1] != s || base[x][2] != b){
                            possible =false;
                            break;
                        }

                    }
                    if (possible) ans++;
                }
            }
        }
        System.out.println(ans);
    }
}
