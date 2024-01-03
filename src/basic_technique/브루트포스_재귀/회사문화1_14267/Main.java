package basic_technique.브루트포스_재귀.회사문화1_14267;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int n;
    static int m;
    static int[] weights;
    static List<Integer>[] tree;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        weights = new int[n + 1];
        weights[1] = 0;
        tree = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++)
            tree[i] = new ArrayList<>();
        for(int i = 1; i <= n ; i++) {
            int senior = sc.nextInt();
            if(senior < 0) continue;
            tree[senior].add(i);
        }

        for(int i = 0; i<m; i++){
            int junior = sc.nextInt();
            int weight = sc.nextInt();
            weights[junior] += weight;
        }

        recFunc(1);

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i<=n; i++)
            sb.append(weights[i] + " ");
        System.out.println(sb);
    }

    private static void recFunc(int senior) {
        for(int i = 0; i < tree[senior].size(); i++){
            Integer junior = tree[senior].get(i);
            weights[junior] += weights[senior];
            recFunc(junior);
        }
    }
}
