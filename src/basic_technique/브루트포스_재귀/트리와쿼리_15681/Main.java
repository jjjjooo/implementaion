package basic_technique.브루트포스_재귀.트리와쿼리_15681;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int n;
    static int r;
    static int q;
    static List<Integer>[] tree;
    static int[] cCnt;
    static boolean[] check;
    static int[] query;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        r = sc.nextInt();
        q = sc.nextInt();

        tree = new ArrayList[n + 1];
        for(int i = 0; i <=n; i++)
            tree[i] = new ArrayList<>();

        for(int i = 0; i <n-1; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            tree[u].add(v);
            tree[v].add(u);
        }
        query = new int[q];
        for(int i = 0; i < q; i++)
            query[i] = sc.nextInt();

        cCnt = new int[n + 1];
        check = new boolean[n + 1];

        recFunc(r);
        for(int i = 0; i < q; i++)
            System.out.println(cCnt[query[i]]);
    }

    static int recFunc(int rNode){
        if(cCnt[rNode] != 0) return cCnt[rNode];
        int cnt = 1;
        check[rNode] = true; // 예는 부모라는 것
        for(int i = 0; i < tree[rNode].size(); i++){
            int child = tree[rNode].get(i);
            if (!check[child]){
                cnt += recFunc(child);
            }
        }
        cCnt[rNode] = cnt;
        return cnt;
    }
}
